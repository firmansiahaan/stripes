package stripesbook.action;

import org.springframework.beans.factory.annotation.Autowired;

import stripesbook.model.User;

public abstract	class UserBaseActionBean extends BaseActionBean {
	@Autowired
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
    	this.user = user;
    }
}
