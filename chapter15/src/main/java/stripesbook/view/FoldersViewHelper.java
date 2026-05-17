package stripesbook.view;

import java.util.Collection;
import stripesbook.action.BaseActionBean;
import stripesbook.model.Folder;

public class FoldersViewHelper extends BaseActionBean {
    public Collection<Folder> getFolders() {
        return getUser().getFolders();
    }
}
