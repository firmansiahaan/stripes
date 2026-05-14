package stripesbook.dao;

import stripesbook.model.Attachment;

public interface AttachmentDao extends Dao<Attachment,Integer> {
    public String getFilePath(Attachment attachment);
    public void deleteFile(Attachment attachment);
}
