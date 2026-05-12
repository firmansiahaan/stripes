/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/

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

