package stripesbook.dao;

import java.util.List;

import stripesbook.model.Contact;
import stripesbook.model.User;

public interface ContactDao extends Dao<Contact,Integer> {
    public Contact findByEmail(String email, User user);
    public List<Contact> findByName(String contactName,  User user);
}