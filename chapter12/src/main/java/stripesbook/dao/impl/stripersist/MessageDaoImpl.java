package stripesbook.dao.impl.stripersist;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.stripesstuff.stripersist.Stripersist;
import stripesbook.dao.MessageDao;
import stripesbook.model.Attachment;
import stripesbook.model.Folder;
import stripesbook.model.Message;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message,Integer>
    implements MessageDao
{
    public void addMessageToFolder(Message message, Folder folder) {
        EntityManager em = Stripersist.getEntityManager(); // Stripersist.getEntityManager();
        em.persist(message);
        message.setFolder(folder);

        for (Attachment attachment : message.getAttachments()) {
            attachment.setMessage(message);
            em.merge(attachment);
        }
    }
    @Override
    public void delete(Message message) {
        EntityManager em = Stripersist.getEntityManager(); // Stripersist.getEntityManager();

        for (Attachment attachment : message.getAttachments()) {
            em.remove(attachment);
        }
        em.remove(message);
    }
}
