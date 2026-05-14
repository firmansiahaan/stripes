package stripesbook.dao;

import stripesbook.model.Folder;
import stripesbook.model.Message;

public interface FolderDao extends Dao<Folder> {
	public Folder read(Integer Id);
    public Message readMessage(Integer messageId);
    public void addMessage(Message message, Folder folder);
    public void deleteMessage(Message message);
    public void sendMessage(Message message);
}

