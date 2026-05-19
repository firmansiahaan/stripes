package stripesbook.action;

import java.util.Collection;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Contact;

@PermitAll
public class ContactListActionBean extends ContactBaseActionBean {
	private static final String LIST="/WEB-INF/jsp/contact_list.jsp";
    private static final String VIEW="/WEB-INF/jsp/contact_view.jsp";
    private static final String TABLE="/WEB-INF/jsp/contact_table.jsp";
    private static final String DETAILS = "/WEB-INF/jsp/parts/contact_details.jsp" ;
    public String filter;

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }
    
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Resolution delete() {
        Contact deleted = getContact();
        contactDao.delete(deleted);
        contactDao.commit();

        getContext().getMessages().add(
            new LocalizableMessage("contactList.deleted", deleted)
        );
        return new RedirectResolution(getClass());
    }

    public Resolution findByName() {
    	if (filter != null && filter.length() > 0) {
    		contacts = contactDao.findByName(filter, getUser());
    	}
    	return new ForwardResolution(TABLE);
    }

    public Collection<Contact> getContacts() {
        return getUser().getContacts();
    }
    
    public Resolution details() {
    	return new ForwardResolution(DETAILS);
    }
    
}
