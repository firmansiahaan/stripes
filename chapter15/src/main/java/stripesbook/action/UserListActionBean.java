package stripesbook.action;

import java.util.List;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HttpCache;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Role;
import stripesbook.model.User;

@HttpCache(allow=false)
@PermitAll
public class UserListActionBean extends UserBaseActionBean {
    private static final String VIEW="/WEB-INF/jsp/user_list.jsp";

    @DefaultHandler
    public Resolution view() {
    	if (userDao != null) {
    		return new ForwardResolution(VIEW);
    	}
    	return null;
    }

    public Resolution save() {
    	for (User user : users) {
    		userDao.save(user);
    	}
    	userDao.commit();
    	getContext().getMessages().add(
    	new LocalizableMessage("userList.saved"));
    	return new RedirectResolution(getClass());
    }

    private List<User> users;
    public List<User> getUsers() {
    	if (userDao != null) {
    		return users = userDao.read();
    	}
    	return null;
    }

    public void setUsers(List<User> users) {
    	this.users = users;
    }
    
    public List<Role> getRoles() {
    	return roleDao.read();
    }
}
