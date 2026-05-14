package stripesbook.dao;

import stripesbook.model.Contact;
import stripesbook.model.User;

public interface ContactDao extends Dao<Contact,Integer> {
    public Contact findByEmail(String email, User user);
}