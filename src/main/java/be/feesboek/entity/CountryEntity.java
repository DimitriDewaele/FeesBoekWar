package be.feesboek.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "COUNTRIES")
@XmlRootElement(name="country")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "CountryEntity.findAll", query = "SELECT c FROM CountryEntity c"),
    @NamedQuery(name = "CountryEntity.findByCountryId", query = "SELECT c FROM CountryEntity c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "CountryEntity.findByCountryIsoCode", query = "SELECT c FROM CountryEntity c WHERE c.countryIsoCode = :countryIsoCode"),
    @NamedQuery(name = "CountryEntity.findByCountryName", query = "SELECT c FROM CountryEntity c WHERE c.countryName = :countryName")})
public class CountryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTRY_ID")
    private Long countryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COUNTRY_ISO_CODE")
    @XmlElement(required=true)
    private String countryIsoCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "COUNTRY_NAME")
    @XmlElement(required=true)
    private String countryName;
    @OneToMany(mappedBy = "country")
    @XmlTransient
    private Collection<UserEntity> userEntityCollection;

    public CountryEntity() {
    }

    public CountryEntity(Long countryId) {
        this.countryId = countryId;
    }

    public CountryEntity(Long countryId, String countryIsoCode, String countryName) {
        this.countryId = countryId;
        this.countryIsoCode = countryIsoCode;
        this.countryName = countryName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public Collection<UserEntity> getUserEntityCollection() {
        return userEntityCollection;
    }

    public void setUserEntityCollection(Collection<UserEntity> userEntityCollection) {
        this.userEntityCollection = userEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryEntity)) {
            return false;
        }
        CountryEntity other = (CountryEntity) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.feesboek.entity.CountryEntity[ countryId=" + countryId + " ]";
    }
    
}
