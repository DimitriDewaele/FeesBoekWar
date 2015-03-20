package be.feesboek.business.message.control;

import be.feesboek.entity.MessageEntity;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dimitridw
 */
@Stateless
//@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MessageService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageService.class);

    @PersistenceContext
    EntityManager em;

    public List<MessageEntity> findAllByNamedQuery() {
        TypedQuery<MessageEntity> query = em.createNamedQuery("MessageEntity.findAll", MessageEntity.class);
        return query.getResultList();
    }

    public List<MessageEntity> findAllByBuilder() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> cq = cb.createQuery(MessageEntity.class);

        Root<MessageEntity> message = cq.from(MessageEntity.class);

        TypedQuery<MessageEntity> query = em.createQuery(cq);

        return query.getResultList();
    }

    public MessageEntity findByFetchGraph(Long id) {
        EntityGraph eg = em.createEntityGraph(MessageEntity.class);
        eg.addAttributeNodes("userId");

        Properties props = new Properties();
        props.put("javax.persistence.loadgraph", eg);
        MessageEntity message = em.find(MessageEntity.class, id, (Map) props);
        return message;
    }
    
    //TODO:
    // - Use a named entity Graph: getEntityGraph + annotations
    // - Use a dynamic Entity graph: createEntityGraph

    public void save(MessageEntity entity) {
        em.persist(entity);
    }
}
