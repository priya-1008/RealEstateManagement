/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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
@Table(name = "statemaster")
@NamedQueries({
    @NamedQuery(name = "Statemaster.findAll", query = "SELECT s FROM Statemaster s"),
    @NamedQuery(name = "Statemaster.findByStateId", query = "SELECT s FROM Statemaster s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "Statemaster.findByStateName", query = "SELECT s FROM Statemaster s WHERE s.stateName = :stateName")})
public class Statemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateId")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "stateName")
    private String stateName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Citymaster> citymasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Propertydetails> propertydetailsCollection;

    public Statemaster() {
    }

    public Statemaster(Integer stateId) {
        this.stateId = stateId;
    }

    public Statemaster(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    @JsonbTransient
    public Collection<Citymaster> getCitymasterCollection() {
        return citymasterCollection;
    }

    public void setCitymasterCollection(Collection<Citymaster> citymasterCollection) {
        this.citymasterCollection = citymasterCollection;
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
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statemaster)) {
            return false;
        }
        Statemaster other = (Statemaster) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Statemaster[ stateId=" + stateId + " ]";
    }
    
}
