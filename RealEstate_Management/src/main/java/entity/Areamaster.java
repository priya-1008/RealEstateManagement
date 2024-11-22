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
@Table(name = "areamaster")
@NamedQueries({
    @NamedQuery(name = "Areamaster.findAll", query = "SELECT a FROM Areamaster a"),
    @NamedQuery(name = "Areamaster.findByAreaId", query = "SELECT a FROM Areamaster a WHERE a.areaId = :areaId"),
    @NamedQuery(name = "Areamaster.findByAreaName", query = "SELECT a FROM Areamaster a WHERE a.areaName = :areaName")})
public class Areamaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "areaId")
    private Integer areaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "areaName")
    private String areaName;
    @JoinColumn(name = "cityId", referencedColumnName = "cityId")
    @ManyToOne(optional = false)
    private Citymaster cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<Propertydetails> propertydetailsCollection;

    public Areamaster() {
    }

    public Areamaster(Integer areaId) {
        this.areaId = areaId;
    }

    public Areamaster(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Citymaster getCityId() {
        return cityId;
    }

    public void setCityId(Citymaster cityId) {
        this.cityId = cityId;
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
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areamaster)) {
            return false;
        }
        Areamaster other = (Areamaster) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Areamaster[ areaId=" + areaId + " ]";
    }
    
}
