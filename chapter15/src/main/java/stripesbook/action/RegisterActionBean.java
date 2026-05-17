package stripesbook.action;

import java.util.Collection;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.Wizard;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMetadata;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.model.Alias;
import stripesbook.model.Folder;
import stripesbook.model.User;
import stripesbook.nonext.PasswordTypeConverter;

@Wizard(startEvents={"view","done"})
@PermitAll
public class RegisterActionBean extends BaseActionBean
    implements ValidationErrorHandler
{
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
        for (String folderName : Folder.DEFAULT_FOLDER_NAMES) {
            folderDao.save(new Folder(folderName, user));
        }
        userDao.commit();
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
    	@Validate(field="firstName" , required=true),
    	@Validate(field="lastName" , required=true),
    	@Validate(field="username" , required=true),
    	@Validate(field="password" , required=true, converter=PasswordTypeConverter.class)
    })  
    private User user;
    public User getUser() {
        return user;
    }  
    public void setUser(User user) {
        this.user = user;
    }
    
    @Validate(required=true, converter=PasswordTypeConverter.class)
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
              new LocalizableError("usernameAlreadyTaken", username));
        }
        if (!user.getPassword().equals(confirmPassword)) {
            errors.addGlobalError(
                new LocalizableError("passwordsDontMatch"));
        }
    }
    
    @ValidationMethod(on="save")
    public void validateAliases(ValidationErrors errors) {
        if (sizeOf(user.getAliases()) != numberOfAliases) {
            errors.addGlobalError(
                new LocalizableError("enterAllAliases"));
        }
        else {
            for (Alias alias : user.getAliases()) {
                if (alias == null) {
                    errors.addGlobalError(
                        new LocalizableError("enterAllAliases"));
                    break;
                }
                if (userDao.findByUsername(alias.getName()) != null) {
                  errors.addGlobalError(
                    new LocalizableError("aliasAlreadyTaken", alias));
                }
            }
        }
    }
    
    public Resolution handleValidationErrors(ValidationErrors errors){
        if (errors.hasFieldErrors()) {
            errors.addGlobalError(
                new LocalizableError("allFieldsRequired"));
        }
        return null;
    }
    private int sizeOf(Collection<?> coll) {
        return (coll == null ? 0 : coll.size());
    }
}