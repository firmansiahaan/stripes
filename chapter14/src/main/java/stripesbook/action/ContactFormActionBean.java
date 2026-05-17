package stripesbook.action;

import java.util.Date;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.model.Contact;
import stripesbook.model.Gender;

@PermitAll
public class ContactFormActionBean extends ContactBaseActionBean {
    private static final String FORM="/WEB-INF/jsp/contact_form.jsp";

    @DefaultHandler
    public Resolution form() {
        return new ForwardResolution(FORM);
    }
    
    public Resolution save() {
        Contact contact = getContact();
        contact.setUser(getUser());
        contactDao.save(contact);
        contactDao.commit();
        getContext().getMessages().add(
            getLocalizableMessage("contactSaved", contact)
        );
        return new RedirectResolution(ContactListActionBean.class);
    }
    
    @DontValidate
    public Resolution cancel() {
        getContext().getMessages().add(
            getLocalizableMessage("actionCancelled")
        );
        return new RedirectResolution(ContactListActionBean.class);
    }

    @ValidateNestedProperties({
        @Validate(field="firstName", maxlength=25),
        @Validate(field="lastName",  minlength=2, maxlength=40),
        @Validate(field="email", required=true, on="save",
            converter=EmailTypeConverter.class),
        @Validate(field="birthDate", expression="${birthDate < today}")
    })
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    @ValidationMethod(on="save")
    public void validateEmailUnique(ValidationErrors errors) {
        String email = getContact().getEmail();
        Contact other = contactDao.findByEmail(email, getUser());
        if (other != null && !other.equals(getContact())) {
            errors.add("contact.email", new LocalizableError(
              getClass().getName()+".contactEmailAlreadyUsed", other));
        }
    }
    public Date getToday() {
        return new Date();
    }
    public Gender[] getGenders() {
        return Gender.values();
    }
}
