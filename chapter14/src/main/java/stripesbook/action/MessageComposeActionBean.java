package stripesbook.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.model.Attachment;
import stripesbook.model.Contact;
import stripesbook.model.Folder;
import stripesbook.model.Message;
import stripesbook.model.User;

@PermitAll
public class MessageComposeActionBean extends BaseActionBean {
    private static final String COMPOSE =
        "/WEB-INF/jsp/message_compose.jsp";

    @DefaultHandler
    public Resolution compose() {
        setMessage(new Message());
        return new ForwardResolution(COMPOSE);
    }
    
    public Resolution send() {
        User user = getUser();
        Message message = getMessage();
        message.setFrom(user.toString());
        message.setDate(new Date());

        messageDao.addMessageToFolder(message,
            folderDao.findByName(Folder.SENT, user));
        messageDao.commit();

        getContext().getMessages().add(
            getLocalizableMessage("messageSentTo", message.getTo()));

        return new RedirectResolution(MessageListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel() {
        for (int index = getMessage().getAttachments().size() - 1;
             index >= 0; index--)
        {
            deleteAttachment(index);
        }
        getContext().getMessages().add(
            getLocalizableMessage("messageCancelled"));
        return new RedirectResolution(MessageListActionBean.class);
    }
    
    public Resolution addTo() {
        getMessage().setTo(getRecipientString(getMessage().getTo()));
        return new ForwardResolution(COMPOSE);
    }
    
    public Resolution addCc() {
        getMessage().setCc(getRecipientString(getMessage().getCc()));
        return new ForwardResolution(COMPOSE);
    }
    
    public Resolution addBcc() {
        getMessage().setBcc(getRecipientString(getMessage().getBcc()));
        return new ForwardResolution(COMPOSE);
    }
    
    public Resolution upload() throws IOException {
        if (attachments != null) {
            for (FileBean attachment : attachments) {
                if (attachment != null) {
                    if (attachment.getSize() > 0) {
                        addAttachment(attachment);
                    }
                    else {
                        ValidationError error = new LocalizableError(
                            "invalidFile", attachment.getFileName());
                        getContext().getValidationErrors().add(
                            "attachments", error);
                    }
                }
            }
        }
        return new ForwardResolution(COMPOSE);
    }
    
    private void addAttachment(FileBean fileBean) throws IOException {
        Attachment attachment = new Attachment();

        attachment.setFileName(fileBean.getFileName());
        attachment.setContentType(fileBean.getContentType());
        attachment.setSize(fileBean.getSize());

        attachmentDao.save(attachment);
        attachmentDao.commit();
        attachment = attachmentDao.read(attachment.getId());
        fileBean.save(new File(attachmentDao.getFilePath(attachment)));
        getMessage().getAttachments().add(attachment);
    }
    
    public Resolution deleteAttachment() {
        deleteAttachment(deleteIndex);
        return new ForwardResolution(COMPOSE);
    }
    
    private void deleteAttachment(int index) {
        Attachment attachment =
            getMessage().getAttachments().remove(index);
        attachmentDao.deleteFile(attachment);
        attachmentDao.delete(attachmentDao.read(attachment.getId()));
        attachmentDao.commit();
    }
    
    private String getRecipientString(String previous) {
        if (contacts != null) {
            StringBuilder result = new StringBuilder();

            for (Contact contact : contacts) {
                result.append(contact).append(',');
            }
            result.setLength(result.length() - 1);
            String recpt = (previous == null) ? "" : previous + ",";
            return recpt + result.toString();
        }
        return previous;
    }
    
    private List<Contact> contacts;
    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    @ValidateNestedProperties({
        @Validate(field="to", required=true, on="send"),
        @Validate(field="subject", required=true, on="send")
    })
    public Message getMessage() {
        return getContext().getMessageCompose();
    }
    public void setMessage(Message message) {
        getContext().setMessageCompose(message);
    }
    
    private List<FileBean> attachments;
    public List<FileBean> getAttachments() {
        return attachments;
    }
    
    public void setAttachments(List<FileBean> attachments) {
        this.attachments = attachments;
    }
    
    private int deleteIndex;
    public int getDeleteIndex() {
        return deleteIndex;
    }
    public void setDeleteIndex(int deleteIndex) {
        this.deleteIndex = deleteIndex;
    }
    
    public Resolution recover() {
    	ValidationError error = new LocalizableError("maximumUpload" , postedSize, maximumSize);
    	getContext().getValidationErrors().add("attachments" , error);
    	return new ForwardResolution(COMPOSE);
   	}

    public long maximumSize, postedSize;

}
