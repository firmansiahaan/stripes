package stripesbook.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.model.User;

public class LoginActionBean extends BaseActionBean {
    private static final String VIEW = "/WEB-INF/jsp/login.jsp";
    private User user;

    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Resolution login() {
        getContext().setUser(user);
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
        user = userDao.findByUsername(username);
        if (user == null) {
            errors.add("username",
                new LocalizableError("primaryEmailNotFound"));
        }
        else if (!user.getPassword().equals(password)) {
            errors.add("password",
                new LocalizableError("passwordIncorrect"));
        }
    }
}
