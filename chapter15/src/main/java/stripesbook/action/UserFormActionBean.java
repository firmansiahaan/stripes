package stripesbook.action;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import stripesbook.model.User;

@PermitAll
public class UserFormActionBean extends BaseActionBean {
    private static final String FORM="/WEB-INF/jsp/user_form.jsp";

    @ValidateNestedProperties({
        @Validate(field="firstName", maxlength=25),
        @Validate(field="lastName",  minlength=2, maxlength=40),
        @Validate(field="email", required=true, on="save",
            converter=EmailTypeConverter.class),
    })
    private User user;
    
    @DefaultHandler
    public Resolution form() {
        return new ForwardResolution(FORM);
    }
    
    public Resolution save() {
        userDao.save(user);
        userDao.commit();
        getContext().getMessages().add(
            getLocalizableMessage("userSaved", user)
        );
        return new RedirectResolution(UserListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel() {
        getContext().getMessages().add(
            getLocalizableMessage("actionCancelled")
        );
        return new RedirectResolution(UserListActionBean.class);
    }
    
}
