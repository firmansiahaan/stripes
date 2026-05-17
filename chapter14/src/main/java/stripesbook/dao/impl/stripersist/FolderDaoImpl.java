package stripesbook.dao.impl.stripersist;

import org.springframework.stereotype.Repository;

import stripesbook.dao.FolderDao;
import stripesbook.model.Folder;
import stripesbook.model.User;

@Repository("folderDao")
public class FolderDaoImpl extends BaseDaoImpl<Folder,Integer>
    implements FolderDao
{
    public Folder findByName(String name, User user) {
        return findBy("name", name, user);
    }
}