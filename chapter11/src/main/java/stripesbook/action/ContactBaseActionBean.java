package stripesbook.action;

import stripesbook.model.Contact;

public abstract class ContactBaseActionBean extends BaseActionBean {
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
