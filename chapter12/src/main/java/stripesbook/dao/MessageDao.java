package stripesbook.dao;

import stripesbook.model.Folder;
import stripesbook.model.Message;

public interface MessageDao extends Dao<Message,Integer> {
    public void addMessageToFolder(Message message, Folder folder);
}
