package stripesbook.ext;

import net.sourceforge.stripes.action.ActionBeanContext;
import stripesbook.dao.mock.MockFolderDao;
import stripesbook.dao.mock.MockUserDao;
import stripesbook.model.Folder;
import stripesbook.model.Message;
import stripesbook.model.User;


public class MyActionBeanContext extends ActionBeanContext {

    private static final String FOLDER  = "folder";
    private static final String MESSAGE = "message";
    private static final String USER = "user";

    public void setCurrentFolder(Folder folder) {
        setCurrent(FOLDER, folder.getId());
    }
    public Folder getCurrentFolder() {
        Folder folder = null;
        Integer folderId = getCurrent(FOLDER, null);
        if (folderId != null) {
            folder = MockFolderDao.getInstance().read(folderId);
        }
        else {
            // folder = folderDao.findByName(Folder.INBOX, getUser());
        }
        return folder;
    }
    public void setMessageCompose(Message message) {
        setCurrent(MESSAGE, message);
    }
    public Message getMessageCompose() {
        return getCurrent(MESSAGE, new Message());
    }
    public void setUser(User user) {
        setCurrent(USER, user.getId());
    }
    public User getUser() {
        Integer userId = getCurrent(USER, null);
        return MockUserDao.getInstance().read(userId);
    }
    protected void setCurrent(String key, Object value) {
        getRequest().getSession().setAttribute(key, value);
    }
    @SuppressWarnings("unchecked")
    protected <T> T getCurrent(String key, T defaultValue) {
        T value = (T) getRequest().getSession().getAttribute(key);
        if (value == null) {
            value = defaultValue;
            setCurrent(key, value);
        }
        return value;
    }

}