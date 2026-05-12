package stripesbook.ext;

import net.sourceforge.stripes.action.ActionBeanContext;
import stripesbook.dao.mock.MockFolderDao;
import stripesbook.model.Folder;
import stripesbook.model.Message;

public class MyActionBeanContext extends ActionBeanContext {
    private static final String FOLDER  = "folder";

    private static final String MESSAGE = "message";


    public void setCurrentFolder(Folder folder) {
        setCurrent(FOLDER, folder);
    }
    
    public Folder getCurrentFolder() {
        Folder folder = MockFolderDao.getInstance().read().get(0);
        return getCurrent(FOLDER, folder);
    }

    public void setMessageCompose(Message message) {
        setCurrent(MESSAGE, message);
    }
    
    public Message getMessageCompose() {
        return getCurrent(MESSAGE, new Message());
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

