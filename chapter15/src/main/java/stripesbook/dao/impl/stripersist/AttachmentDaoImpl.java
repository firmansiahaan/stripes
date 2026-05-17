package stripesbook.dao.impl.stripersist;

import java.io.File;

import org.springframework.stereotype.Repository;

import stripesbook.dao.AttachmentDao;
import stripesbook.model.Attachment;

@Repository("attachmentDao")
public class AttachmentDaoImpl extends BaseDaoImpl<Attachment,Integer>
    implements AttachmentDao
{
    private static final String DIRECTORY =
        System.getProperty("user.home") + File.separator +
            "webmail_attachments" + File.separator;

    public String getFilePath(Attachment attachment) {
        return DIRECTORY + attachment.getId() + "_" +
            attachment.getFileName();
    }
    public void deleteFile(Attachment attachment) {
        new File(getFilePath(attachment)).delete();
    }
}
