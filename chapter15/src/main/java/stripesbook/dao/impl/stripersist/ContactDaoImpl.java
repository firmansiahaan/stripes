package stripesbook.dao.impl.stripersist;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.stripesstuff.stripersist.Stripersist;

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
    
    @SuppressWarnings("unchecked" )
	public List<Contact> findByName(String startsWith, User user) {
		return Stripersist.getEntityManager().createQuery(
				"select distinct c from "
				+  "contact c "
				+ "where (c.firstName like '" + startsWith + "%' or "
				+ "c.lastName like '" + startsWith + "%') "
				+ "and c.user = :user"
			).setParameter("user" , user).getResultList();
    }

}



