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

public class ContactListActionBean extends ContactBaseActionBean {
	
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
		Contact deleted = contactDao.read(getContact());
		contactDao.delete(getContact());
		getContext().getMessages().add(
			new SimpleMessage("Deleted {0}." , deleted));
		return new RedirectResolution(getClass());
	}
	
	public List<Contact> getContacts() {
		return contactDao.read();
	}
	
}
