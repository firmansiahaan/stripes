package stripesbook.dao;

import stripesbook.model.Folder;
import stripesbook.model.User;

public interface FolderDao extends Dao<Folder,Integer> {
    public Folder findByName(String name, User user);
}
