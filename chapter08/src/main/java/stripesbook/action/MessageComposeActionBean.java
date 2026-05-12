package stripesbook.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.dao.AttachmentDao;
import stripesbook.dao.FolderDao;
import stripesbook.dao.mock.MockAttachmentDao;
import stripesbook.dao.mock.MockFolderDao;
import stripesbook.model.Attachment;
import stripesbook.model.Contact;
import stripesbook.model.Message;

public class MessageComposeActionBean extends ContactBaseActionBean {
    private static final String COMPOSE =
        "/WEB-INF/jsp/message_compose.jsp";

    @DefaultHandler
    public Resolution compose() {
        setMessage(new Message());
        return new ForwardResolution(COMPOSE);
    }
    
    public Resolution send() {
        Message message = getMessage();
        message.setDate(new Date());
        folderDao.sendMessage(message);
        getContext().getMessages().add(
            new SimpleMessage("Message sent to " + message.getTo()));
        return new RedirectResolution(MessageListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel() {
        getContext().getMessages().add(
            new SimpleMessage("Message cancelled."));
        return new RedirectResolution(MessageListActionBean.class);
    }
    
    @DontValidate
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
    
    public Resolution upload() throws Exception {
        if (attachments != null) { /* (1) */
            for (FileBean attachment : attachments) {
                if (attachment != null) { /* (2) */
                    if (attachment.getSize() > 0) { /* (3) */
                        addAttachment(attachment);
                    }
                    else {
                        ValidationError error = new SimpleError(
                            attachment.getFileName()
                            + " is not a valid file.");
                        getContext().getValidationErrors().add(
                            "attachments", error);
                    }
                }
            }
        }
        return new ForwardResolution(COMPOSE);
    }
    
    private void addAttachment(FileBean fileBean) throws Exception {
        Attachment attachment = new Attachment();

        attachment.setFileName(fileBean.getFileName());
        attachment.setContentType(fileBean.getContentType());
        attachment.setSize(fileBean.getSize());

        attachmentDao.save(attachment);
        fileBean.save(new File(attachmentDao.getFilePath(attachment))); /* (4) */
        getMessage().addAttachment(attachment);
    }
    
    
    public Resolution deleteAttachment() throws Exception {
        Attachment attachment =
            getMessage().getAttachments().remove(deleteIndex);

        attachmentDao.delete(attachment.getId());

        return new ForwardResolution(COMPOSE);
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

    private AttachmentDao attachmentDao =
        MockAttachmentDao.getInstance();

    private FolderDao folderDao = MockFolderDao.getInstance();
}