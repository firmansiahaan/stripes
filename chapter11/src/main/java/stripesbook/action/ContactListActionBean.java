package stripesbook.action;

import java.util.Collection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Contact;

public class ContactListActionBean extends ContactBaseActionBean {
    private static final String LIST="/WEB-INF/jsp/contact_list.jsp";
    private static final String VIEW="/WEB-INF/jsp/contact_view.jsp";

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

    public Collection<Contact> getContacts() {
        return getUser().getContacts();
    }
}
