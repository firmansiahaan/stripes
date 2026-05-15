package stripesbook.dao.impl.stripersist;

import org.springframework.stereotype.Repository;

import stripesbook.dao.ContactDao;
import stripesbook.model.Contact;
import stripesbook.model.User;

@Repository("contactDao")
public class ContactDaoImpl extends BaseDaoImpl<Contact,Integer>
    implements ContactDao
{
    public Contact findByEmail(String email, User user) {
        return findBy("email", email, user);
    }
}

