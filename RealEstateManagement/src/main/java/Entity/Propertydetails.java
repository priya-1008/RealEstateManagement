/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "propertydetails")
@NamedQueries({
    @NamedQuery(name = "Propertydetails.findAll", query = "SELECT p FROM Propertydetails p"),
    @NamedQuery(name = "Propertydetails.findByPropertyId", query = "SELECT p FROM Propertydetails p WHERE p.propertyId = :propertyId"),
    @NamedQuery(name = "Propertydetails.findByDescription", query = "SELECT p FROM Propertydetails p WHERE p.description = :description"),
    @NamedQuery(name = "Propertydetails.findByPrice", query = "SELECT p FROM Propertydetails p WHERE p.price = :price"),
    @NamedQuery(name = "Propertydetails.findByYearBuilt", query = "SELECT p FROM Propertydetails p WHERE p.yearBuilt = :yearBuilt"),
    @NamedQuery(name = "Propertydetails.findByStatus", query = "SELECT p FROM Propertydetails p WHERE p.status = :status"),
    @NamedQuery(name = "Propertydetails.findByType", query = "SELECT p FROM Propertydetails p WHERE p.type = :type")})
public class Propertydetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "propertyId")
    private Integer propertyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearBuilt")
    @Temporal(TemporalType.DATE)
    private Date yearBuilt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Transactiondetails> transactiondetailsCollection;
    @JoinColumn(name = "areaId", referencedColumnName = "areaId")
    @ManyToOne(optional = false)
    private Areamaster areaId;
    @JoinColumn(name = "cityId", referencedColumnName = "cityId")
    @ManyToOne(optional = false)
    private Citymaster cityId;
    @JoinColumn(name = "stateId", referencedColumnName = "stateId")
    @ManyToOne(optional = false)
    private Statemaster stateId;
    @JoinColumn(name = "imageId", referencedColumnName = "imageId")
    @ManyToOne(optional = false)
    private Propertyimage imageId;

    public Propertydetails() {
    }

    public Propertydetails(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Propertydetails(Integer propertyId, String description, double price, String address, Date yearBuilt, String status, String type) {
        this.propertyId = propertyId;
        this.description = description;
        this.price = price;
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.status = status;
        this.type = type;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Date yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @JsonbTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }
    @JsonbTransient
    public Collection<Transactiondetails> getTransactiondetailsCollection() {
        return transactiondetailsCollection;
    }

    public void setTransactiondetailsCollection(Collection<Transactiondetails> transactiondetailsCollection) {
        this.transactiondetailsCollection = transactiondetailsCollection;
    }

    public Areamaster getAreaId() {
        return areaId;
    }

    public void setAreaId(Areamaster areaId) {
        this.areaId = areaId;
    }

    public Citymaster getCityId() {
        return cityId;
    }

    public void setCityId(Citymaster cityId) {
        this.cityId = cityId;
    }

    public Statemaster getStateId() {
        return stateId;
    }

    public void setStateId(Statemaster stateId) {
        this.stateId = stateId;
    }

    public Propertyimage getImageId() {
        return imageId;
    }

    public void setImageId(Propertyimage imageId) {
        this.imageId = imageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertydetails)) {
            return false;
        }
        Propertydetails other = (Propertydetails) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Propertydetails[ propertyId=" + propertyId + " ]";
    }
    
}
