package stripesbook.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.LocalizableMessage;
import stripesbook.dao.AttachmentDao;
import stripesbook.dao.ContactDao;
import stripesbook.dao.FolderDao;
import stripesbook.dao.UserDao;
import stripesbook.dao.mock.MockAttachmentDao;
import stripesbook.dao.mock.MockContactDao;
import stripesbook.dao.mock.MockFolderDao;
import stripesbook.dao.mock.MockUserDao;
import stripesbook.ext.MyActionBeanContext;
import stripesbook.ext.MyLocalePicker;
import stripesbook.model.Folder;
import stripesbook.model.User;

public abstract class BaseActionBean implements ActionBean {
	
	protected AttachmentDao attachmentDao = MockAttachmentDao.getInstance();
	protected ContactDao contactDao = MockContactDao.getInstance();
	protected FolderDao folderDao = MockFolderDao.getInstance();
	protected UserDao userDao = MockUserDao.getInstance();
	
    private MyActionBeanContext context;

    public MyActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = (MyActionBeanContext) context;
    }
    public void setFolder(Folder folder) {
        getContext().setCurrentFolder(folder);
    }

    public String getLastUrl() {
        HttpServletRequest req = getContext().getRequest();
        StringBuilder sb = new StringBuilder();

        // Start with the URI and the path
        String uri = (String)
            req.getAttribute("javax.servlet.forward.request_uri");
        String path = (String)
            req.getAttribute("javax.servlet.forward.path_info");
        if (uri == null) {
            uri = req.getRequestURI(); 
            path = req.getPathInfo(); 
        }
        sb.append(uri);
        if (path != null) { sb.append(path); }

        // Now the request parameters
        sb.append('?');
        Map<String,String[]> map =
            new HashMap<String,String[]>(req.getParameterMap());

        // Remove previous locale parameter, if present.
        map.remove(MyLocalePicker.LOCALE);

        // Append the parameters to the URL
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            for (String value : values) {
                sb.append(key).append('=').append(value).append('&');
            }
        }
        // Remove the last '&'
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
    
    protected LocalizableMessage getLocalizableMessage(String key,
        Object... parameters)
    {
        return new LocalizableMessage(
            getClass().getName() + "." + key, parameters);
    }

    protected User user;
    public void setUser(User user) {
    	this.user = user;
	}
	public User getUser() {
		if (this.user == null) {
			MockUserDao mockUserDao = MockUserDao.getInstance();
			User usr = mockUserDao.findByUsername("freddy");
			setUser(usr);
		}
        return user;
    }

}