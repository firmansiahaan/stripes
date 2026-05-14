package stripesbook.action;

import java.util.Date;

import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import stripesbook.dao.ContactDao;
import stripesbook.dao.mock.MockContactDao;
import stripesbook.model.Contact;

public class ContactBaseActionBean extends BaseActionBean {

	private ContactDao contactDao = MockContactDao.getInstance();
	protected ContactDao getContactDao() {
		return contactDao;
	}
	
	private Integer contactId;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer id) {
		contactId = id;
	}
	
	private Contact contact;
	public Contact getContact() {
		return contact;
	}
	@ValidateNestedProperties({
		@Validate(field="email", required=true, converter=EmailTypeConverter.class, on="save", label="Email"),
		@Validate(field="firstName", maxlength=40, on="save", label="First Name"),
		@Validate(field="lastName", minlength=2, maxlength=40, on="save", label="Last Name"),
		@Validate(field="birthDate", expression="${birthDate < today}", on="save", label="Date of Birth"),
		@Validate(field="phoneNumber", mask="\\(?\\d{3}\\)?[-. ]?\\d{3}[-. ]?\\d{4}", on="save", label="Telephone Number" )
	})
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public Date getToday() {
		return new Date();
	}
	
	@ValidationMethod(on="save" )
	public void validateEmailUnique(ValidationErrors errors) {
		if (contact != null) {
			String email = contact.getEmail();
			Contact other = getContactDao().findByEmail(email);
			if (other != null && !other.equals(contact)) {
				errors.add("contact.email" , new SimpleError("{1} is already used by {2}." , other));
			}
		}
	}
	
}
