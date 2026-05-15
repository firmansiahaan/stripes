package stripesbook.ext.guice.config;

import com.google.inject.AbstractModule;

import stripesbook.dao.AttachmentDao;
import stripesbook.dao.ContactDao;
import stripesbook.dao.FolderDao;
import stripesbook.dao.MessageDao;
import stripesbook.dao.UserDao;
import stripesbook.dao.impl.stripersist.AttachmentDaoImpl;
import stripesbook.dao.impl.stripersist.ContactDaoImpl;
import stripesbook.dao.impl.stripersist.FolderDaoImpl;
import stripesbook.dao.impl.stripersist.MessageDaoImpl;
import stripesbook.dao.impl.stripersist.UserDaoImpl;

public class GuiceConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AttachmentDao.class).to(AttachmentDaoImpl.class);
		bind(ContactDao.class).to(ContactDaoImpl.class);
		bind(FolderDao.class).to(FolderDaoImpl.class);
		bind(MessageDao.class).to(MessageDaoImpl.class);
		bind(UserDao.class).to(UserDaoImpl.class);
	}
	
}
