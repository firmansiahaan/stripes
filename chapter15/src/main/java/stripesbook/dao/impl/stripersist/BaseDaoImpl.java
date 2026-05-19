package stripesbook.dao.impl.stripersist;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.stripesstuff.stripersist.Stripersist;

import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.metamodel.EntityType;
import stripesbook.dao.Dao;
import stripesbook.model.User;

public abstract class BaseDaoImpl<T,ID extends Serializable>
    implements Dao<T,ID>
{
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = (Class<T>)
            ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
    }
    
    protected Session getSession() {
    	return (Session) Stripersist.getEntityManager().getDelegate();
    }
    
    /* methods... */
    @SuppressWarnings("unchecked")
    public List<T> read() {
        return Stripersist.getEntityManager("stripes_webmail")
            .createQuery("from " + entityClass.getName())
            .getResultList();
    }
    public T read(ID id) {
        return Stripersist.getEntityManager("stripes_webmail").find(entityClass, id);
    }


    public void save(T object) {
        Stripersist.getEntityManager("stripes_webmail").persist(object);
    }
    public void delete(T object) {
        Stripersist.getEntityManager("stripes_webmail").remove(object);
    }
    public void commit() {
        Stripersist.getEntityManager("stripes_webmail").getTransaction().commit();
    }


    public T findBy(String fieldName, Object value) {
        Query query = Stripersist.getEntityManager("stripes_webmail")
            .createQuery(getQuery(fieldName, null))
            .setParameter(fieldName, value);
        return getSingleResult(query);
    }

    public T findBy(String fieldName, Object value, User user) {
        Query query = Stripersist.getEntityManager("stripes_webmail")
            .createQuery(getQuery(fieldName, user))
            .setParameter(fieldName, value)
            .setParameter("user", user);
        return getSingleResult(query);
    }
    
    private String getQuery(String fieldName, User user){
        String query =
            "from " + entityClass.getName() + " t " +
            "where t." + fieldName + " = :" + fieldName;
        if (user == null) {
            return query;
        }
        return query + " and t.user = :user";
    }
    @SuppressWarnings("unchecked")
    private T getSingleResult(Query query) {
        try {
            return (T) query.getSingleResult();
        }
        catch (NonUniqueResultException exc) {
            return (T) query.getResultList().get(0);
        }
        catch (NoResultException exc) {
            return null;
        }
    }
    
    public Class<?> getEntityClass(EntityManager entityManager, String entityName) {
        for (EntityType<?> entity : entityManager.getMetamodel().getEntities()) {
            if (entityName.equals(entity.getName())) {
                return entity.getJavaType();
            }
        }
        return null;
    }
}