package stripesbook.ext.init;

import org.stripesstuff.stripersist.StripersistInit;

import stripesbook.dao.RoleDao;
import stripesbook.dao.impl.stripersist.RoleDaoImpl;
import stripesbook.model.Role;

public class DataInit implements StripersistInit {
	
	private RoleDao roleDao = new RoleDaoImpl();
	public void init() {
		if (roleDao.read().isEmpty()) {
			roleDao.save(new Role("User"));
			roleDao.save(new Role("Administrator"));
			roleDao.commit();
		}
	}
}
