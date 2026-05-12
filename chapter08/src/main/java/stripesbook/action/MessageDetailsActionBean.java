package stripesbook.action;

import java.io.FileInputStream;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import stripesbook.dao.AttachmentDao;
import stripesbook.dao.mock.MockAttachmentDao;
import stripesbook.model.Attachment;
import stripesbook.model.Message;

public class MessageDetailsActionBean extends BaseActionBean {
    private static String VIEW = "/WEB-INF/jsp/message_details.jsp";
	
    
    
    private Message message;
    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Integer attachmentId;
    public Resolution downloadAttachment() throws Exception {
        Attachment attachment = attachmentDao.read(attachmentId);
        String fileName = attachment.getFileName();
        String filePath = attachmentDao.getFilePath(attachment);
        return new StreamingResolution(attachment.getContentType(),
            new FileInputStream(filePath)).setFilename(fileName);
    }
    
    private AttachmentDao attachmentDao = MockAttachmentDao.getInstance();

}
