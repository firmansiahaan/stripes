/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/
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
