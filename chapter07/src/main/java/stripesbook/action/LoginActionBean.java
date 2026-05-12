/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/
package stripesbook.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.dao.UserDao;
import stripesbook.dao.mock.MockUserDao;
import stripesbook.model.User;

public class LoginActionBean extends BaseActionBean {
    private static final String VIEW = "/WEB-INF/jsp/login.jsp";

    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Resolution login() {
        return new RedirectResolution(MessageListActionBean.class);
    }
    @Validate(required=true)
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Validate(required=true)
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @ValidationMethod
    public void validateUser(ValidationErrors errors) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            errors.add("username",
                new SimpleError("The primary email was not found."));
        }
        else if (!user.getPassword().equals(password)) {
            errors.add("password",
                new SimpleError("The password is incorrect."));
        }
    }
    
    private UserDao userDao = MockUserDao.getInstance();
    
}
