package stripesbook.action;

import stripesbook.model.Contact;
import stripesbook.model.User;

public abstract class ContactBaseActionBean extends BaseActionBean {
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
    	User user = contact.getUser();
    	if (user == null || getUser().equals(user)) {
    		this.contact = contact;
    	}
    }
}
