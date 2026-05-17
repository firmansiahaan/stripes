package stripesbook.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.annotation.security.RolesAllowed;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import stripesbook.model.Attachment;
import stripesbook.model.Message;

@RolesAllowed({"Administrator" ,"User if ${user eq message.folder.user}"})
public class MessageDetailsActionBean extends BaseActionBean {
    private static String VIEW = "/WEB-INF/jsp/message_details.jsp";

    private Message message;
    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
    	if (getUser().equals(message.getFolder().getUser())) {
    		this.message = message;
    	}
    }
    
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Attachment attachment;

    public Resolution downloadAttachment()
        throws FileNotFoundException
    {
        String fileName = attachment.getFileName();
        String filePath = attachmentDao.getFilePath(attachment);
        return new StreamingResolution(attachment.getContentType(),
            new FileInputStream(filePath)).setFilename(fileName);
    }
}
