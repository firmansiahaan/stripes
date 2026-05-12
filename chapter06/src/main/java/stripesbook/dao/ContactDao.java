package stripesbook.dao;

import stripesbook.model.Contact;

public interface ContactDao extends Dao<Contact> {
    public Contact findByEmail(String email);
}
