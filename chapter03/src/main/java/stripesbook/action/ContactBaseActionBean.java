package stripesbook.action;

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
		if (contactId != null) {
			return contactDao.read(contactId);
		}
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
