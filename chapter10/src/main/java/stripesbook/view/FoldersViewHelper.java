package stripesbook.view;

import java.util.List;

import stripesbook.dao.FolderDao;
import stripesbook.dao.mock.MockFolderDao;
import stripesbook.model.Folder;

public class FoldersViewHelper {
    private FolderDao folderDao = MockFolderDao.getInstance();

    public List<Folder> getFolders() {
        return folderDao.read();
    }
}

