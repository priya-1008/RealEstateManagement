/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "citymaster")
@NamedQueries({
    @NamedQuery(name = "Citymaster.findAll", query = "SELECT c FROM Citymaster c"),
    @NamedQuery(name = "Citymaster.findByCityId", query = "SELECT c FROM Citymaster c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "Citymaster.findByCityName", query = "SELECT c FROM Citymaster c WHERE c.cityName = :cityName")})
public class Citymaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityId")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cityName")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<Areamaster> areamasterCollection;
    @JoinColumn(name = "stateId", referencedColumnName = "stateId")
    @ManyToOne(optional = false)
    private Statemaster stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<Propertydetails> propertydetailsCollection;

    public Citymaster() {
    }

    public Citymaster(Integer cityId) {
        this.cityId = cityId;
    }

    public Citymaster(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonbTransient
    public Collection<Areamaster> getAreamasterCollection() {
        return areamasterCollection;
    }

    public void setAreamasterCollection(Collection<Areamaster> areamasterCollection) {
        this.areamasterCollection = areamasterCollection;
    }

    public Statemaster getStateId() {
        return stateId;
    }

    public void setStateId(Statemaster stateId) {
        this.stateId = stateId;
    }

    @JsonbTransient
    public Collection<Propertydetails> getPropertydetailsCollection() {
        return propertydetailsCollection;
    }

    public void setPropertydetailsCollection(Collection<Propertydetails> propertydetailsCollection) {
        this.propertydetailsCollection = propertydetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citymaster)) {
            return false;
        }
        Citymaster other = (Citymaster) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Citymaster[ cityId=" + cityId + " ]";
    }
    
}
