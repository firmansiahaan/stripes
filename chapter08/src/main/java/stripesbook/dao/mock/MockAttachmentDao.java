package stripesbook.dao.mock;

import java.io.File;
import stripesbook.dao.AttachmentDao;
import stripesbook.model.Attachment;

public class MockAttachmentDao extends MockDao<Attachment>
    implements AttachmentDao
{
    private static final String DIRECTORY =
        System.getProperty("user.home") + File.separator +
            "webmail_attachments" + File.separator;

    private MockAttachmentDao() {
    }
    private static MockAttachmentDao instance = new MockAttachmentDao();
    public static MockAttachmentDao getInstance() { return instance; }

    public String getFilePath(Attachment attachment) {
        return DIRECTORY + attachment.getId() + "_" +
            attachment.getFileName();
    }
    @Override
    public void delete(Integer id) {
        new File(getFilePath(read(id))).delete();
        super.delete(id);
    }
}
