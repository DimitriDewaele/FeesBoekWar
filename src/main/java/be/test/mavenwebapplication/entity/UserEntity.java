package be.test.mavenwebapplication.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dimitridw
 */
@Entity
@Table(name = "USERS")
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserEntity.findByUsername", query = "SELECT u FROM UserEntity u WHERE u.username = :username"),
    @NamedQuery(name = "UserEntity.findByFirstname", query = "SELECT u FROM UserEntity u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "UserEntity.findByLastname", query = "SELECT u FROM UserEntity u WHERE u.lastname = :lastname")})
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "USERNAME")
    @XmlElement(required=true)
    private String username;
    @Size(max = 256)
    @Column(name = "FIRSTNAME")
    @XmlElement(required=true)
    private String firstname;
    @Size(max = 256)
    @Column(name = "LASTNAME")
    @XmlElement(required=true)
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @XmlTransient
    private Collection<MessageEntity> messageEntityCollection;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne
    @XmlTransient
    private CountryEntity country;

    public UserEntity() {
    }

    public UserEntity(Long userId) {
        this.userId = userId;
    }

    public UserEntity(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<MessageEntity> getMessageEntityCollection() {
        return messageEntityCollection;
    }

    public void setMessageEntityCollection(Collection<MessageEntity> messageEntityCollection) {
        this.messageEntityCollection = messageEntityCollection;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.test.mavenwebapplication.entity.UserEntity[ userId=" + userId + " ]";
    }
    
}
