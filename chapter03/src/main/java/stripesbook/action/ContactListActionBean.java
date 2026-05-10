package stripesbook.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import stripesbook.dao.ContactDao;
import stripesbook.dao.mock.MockContactDao;
import stripesbook.model.Contact;

public class ContactListActionBean extends BaseActionBean {
	
	private static final String LIST= "/WEB-INF/jsp/contact_list.jsp" ;
	
	private ContactDao contactDao = MockContactDao.getInstance();

	@DefaultHandler
	public Resolution list() {
		return new ForwardResolution(LIST);
	}
	
	private static final String VIEW="/WEB-INF/jsp/contact_view.jsp" ;
	public Resolution view() {
		return new ForwardResolution(VIEW);
	}

	public Resolution delete() {
		Contact deleted = contactDao.read(contactId);
		contactDao.delete(contactId);
		getContext().getMessages().add(
			new SimpleMessage("Deleted {0}." , deleted));
		return new RedirectResolution(getClass());
	}
	
	private Integer contactId;
	public void setContactId(Integer id) {
		contactId = id;
	}
	public Contact getContact() {
		return contactDao.read(contactId);
	}
	
	public List<Contact> getContacts() {
		return contactDao.read();
	}
	
}
