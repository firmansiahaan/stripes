/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/

package stripesbook.action;


import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.Wizard;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMetadata;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.dao.UserDao;
import stripesbook.dao.mock.MockUserDao;
import stripesbook.model.User;

/*
START:password
public class RegisterActionBean extends BaseActionBean {
END:password
*/

@Wizard(startEvents={"view","done"})

public class RegisterActionBean extends BaseActionBean
    implements ValidationErrorHandler {

    private static final String VIEW = "/WEB-INF/jsp/register.jsp";
    private static final String ALIASES = "/WEB-INF/jsp/aliases.jsp";
    private static final String DONE = "/WEB-INF/jsp/reg_complete.jsp";

    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Resolution register() {
        if (numberOfAliases > 0) {
            return new ForwardResolution(ALIASES);
        }
        return save();
    }
    public Resolution save() {
        userDao.save(user);
        return new RedirectResolution(getClass(), "done");
    }
    @DontValidate
    public Resolution done() {
        return new ForwardResolution(DONE);
    }
    @DontValidate
    public Resolution cancel() {
        return new RedirectResolution(LoginActionBean.class);
    }

    @ValidateNestedProperties({
        @Validate(field="firstName", required=true),
        @Validate(field="lastName",  required=true),
        @Validate(field="username",  required=true),
        @Validate(field="password",  required=true)
    })
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Validate(required=true)
    private String confirmPassword;
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Validate(required=true, minvalue=0, maxvalue=5)
    private Integer numberOfAliases;

    public Integer getNumberOfAliases() {
        return numberOfAliases;
    }
    public void setNumberOfAliases(Integer numberOfAliases) {
        this.numberOfAliases = numberOfAliases;
    }

    public int getMinAliases() {
        return getAliasValidation().minvalue().intValue();
    }
    public int getMaxAliases() {
        return getAliasValidation().maxvalue().intValue();
    }
    private ValidationMetadata getAliasValidation() {
        return StripesFilter.getConfiguration()
          .getValidationMetadataProvider()
          .getValidationMetadata(getClass())
          .get("numberOfAliases");
    }

    @ValidationMethod
    public void validateUsernameAndPasswords(ValidationErrors errors){
        String username = user.getUsername();
        if (userDao.findByUsername(username) != null) {
            errors.addGlobalError(
                new SimpleError(username + " is already taken."));
        }
        if (!user.getPassword().equals(confirmPassword)) {
            errors.addGlobalError(
                new SimpleError("The passwords do not match."));
        }
    }
    
    @ValidationMethod(on="save")
    public void validateAliases(ValidationErrors errors) {
        if (sizeOf(user.getAliases()) != numberOfAliases) {
            errors.addGlobalError(
                new SimpleError("Please enter all aliases."));
        }
        else {
            for (String alias : user.getAliases()) {
                if (alias == null) {
                    errors.addGlobalError(
                        new SimpleError("Please enter all aliases."));
                    break;
                }
                if (userDao.findByUsername(alias) != null) {
                    errors.addGlobalError(
                        new SimpleError(alias + " is already taken."));
                }
            }
        }
    }
    
    public Resolution handleValidationErrors(ValidationErrors errors){
        if (errors.hasFieldErrors()) {
            errors.addGlobalError(
                new SimpleError("All fields are required."));
        }
        return null;
    }
    
    private int sizeOf(List<?> list) {
        return (list == null ? 0 : list.size());
    }

    /* ... */

    private UserDao userDao = MockUserDao.getInstance();

}