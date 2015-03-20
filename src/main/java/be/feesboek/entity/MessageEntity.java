package be.feesboek.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dimitridw
 */
@Entity
@Table(name = "MESSAGES")
@XmlRootElement(name="message")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "MessageEntity.findAll", query = "SELECT m FROM MessageEntity m"),
    @NamedQuery(name = "MessageEntity.findByMessageId", query = "SELECT m FROM MessageEntity m WHERE m.messageId = :messageId"),
    @NamedQuery(name = "MessageEntity.findByTitle", query = "SELECT m FROM MessageEntity m WHERE m.title = :title"),
    @NamedQuery(name = "MessageEntity.findByMessage", query = "SELECT m FROM MessageEntity m WHERE m.message = :message"),
    @NamedQuery(name = "MessageEntity.findBySubmitTime", query = "SELECT m FROM MessageEntity m WHERE m.submitTime = :submitTime")})
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Size(max = 128)
    @Column(name = "TITLE")
    @XmlElement(required=true)
    private String title;
    @Size(max = 1024)
    @Column(name = "MESSAGE")
    @XmlElement(required=true)
    private String message;
    @Column(name = "SUBMIT_TIME")
    @XmlElement(required=true)
    private Date submitTime;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private UserEntity userId;

    public MessageEntity() {
    }

    public MessageEntity(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageEntity)) {
            return false;
        }
        MessageEntity other = (MessageEntity) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.feesboek.entity.MessageEntity[ messageId=" + messageId + " ]";
    }
    
}
