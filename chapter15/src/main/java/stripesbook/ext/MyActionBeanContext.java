package stripesbook.ext;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringBean;
import stripesbook.dao.FolderDao;
import stripesbook.dao.UserDao;
import stripesbook.model.Folder;
import stripesbook.model.Message;
import stripesbook.model.User;

public class MyActionBeanContext extends ActionBeanContext {

    private static final String FOLDER  = "folder";
    private static final String MESSAGE = "message";
    private static final String USER = "user";


    @SpringBean private FolderDao folderDao;
    @SpringBean private UserDao userDao;


    public void setCurrentFolder(Folder folder) {
        setCurrent(FOLDER, folder.getId());
    }
    
    public Folder getCurrentFolder() {
        Folder folder = null;
        Integer folderId = getCurrent(FOLDER, null);
        if (folderId != null) {
            folder = folderDao.read(folderId);
        }
        else {
            folder = folderDao.findByName(Folder.INBOX, getUser());
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
    	Integer userid = (user == null ? 0 : user.getId());
        setCurrent(USER, userid);
    }
    
    public User getUser() {
        Integer userId = getCurrent(USER, null);
        userId = (userId == null ? 0 : userId);
        return userDao.read(userId);
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

    public void logout() {
    	setUser(null);
    	HttpSession session = getRequest().getSession();
    	if (session != null) {
    		session.invalidate();
    	}
    }
}