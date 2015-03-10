package be.test.mavenwebapplication.business.message.boundary;

import be.test.mavenwebapplication.business.message.control.MessageService;
import be.test.mavenwebapplication.entity.MessageEntity;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class MessageBoundary implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageBoundary.class);

    @Inject
    MessageService messageService;

    public List<MessageEntity> findAllByNamedQuery() {
        return messageService.findAllByNamedQuery();
    }

    public List<MessageEntity> findAllByBuilder() {
        return messageService.findAllByBuilder();
    }

    public MessageEntity findByFetchGraph(Long userId) {
        return messageService.findByFetchGraph(userId);
    }

    public void save(MessageEntity entity) {
        messageService.save(entity);
    }

}
