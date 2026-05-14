package stripesbook.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.integration.spring.SpringBean;
import stripesbook.dao.AttachmentDao;
import stripesbook.dao.ContactDao;
import stripesbook.dao.FolderDao;
import stripesbook.dao.MessageDao;
import stripesbook.dao.UserDao;
import stripesbook.dao.impl.stripersist.UserDaoImpl;
import stripesbook.ext.MyActionBeanContext;
import stripesbook.ext.MyLocalePicker;
import stripesbook.model.Folder;
import stripesbook.model.User;

public abstract class BaseActionBean implements ActionBean {

	@SpringBean protected AttachmentDao attachmentDao;
	@SpringBean protected ContactDao contactDao;
	@SpringBean protected FolderDao folderDao;
	@SpringBean protected MessageDao messageDao;
	@SpringBean protected UserDao userDao;
	
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
			User usr = (new UserDaoImpl()).read().get(0);
			setUser(usr);
		}
        return user;
    }

//    protected AttachmentDao attachmentDao = new AttachmentDaoImpl();
//    protected ContactDao contactDao = new ContactDaoImpl();
//    protected FolderDao folderDao = new FolderDaoImpl();
//    protected MessageDao messageDao = new MessageDaoImpl();
//    protected UserDao userDao = new UserDaoImpl();
}