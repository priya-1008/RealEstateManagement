/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
    @NamedQuery(name = "Propertydetails.findByPropertyType", query = "SELECT p FROM Propertydetails p WHERE p.propertyType = :propertyType"),
    @NamedQuery(name = "Propertydetails.findByPropertyPrice", query = "SELECT p FROM Propertydetails p WHERE p.propertyPrice = :propertyPrice"),
    @NamedQuery(name = "Propertydetails.findByStatus", query = "SELECT p FROM Propertydetails p WHERE p.status = :status"),
    @NamedQuery(name = "Propertydetails.findByAddress", query = "SELECT p FROM Propertydetails p WHERE p.address = :address"),
    @NamedQuery(name = "Propertydetails.findByYearBuilt", query = "SELECT p FROM Propertydetails p WHERE p.yearBuilt = :yearBuilt")})
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
    @Size(min = 1, max = 10)
    @Column(name = "propertyType")
    private String propertyType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propertyPrice")
    private double propertyPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearBuilt")
    @Temporal(TemporalType.DATE)
    private Date yearBuilt;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
//    private Collection<Propertyimages> propertyimagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Transactiondetails> transactiondetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Feedbackdetails> feedbackdetailsCollection;
    @JoinColumn(name = "areaId", referencedColumnName = "areaId")
    @ManyToOne(optional = false)
    private Areamaster areaId;
    @JoinColumn(name = "cityId", referencedColumnName = "cityId")
    @ManyToOne(optional = false)
    private Citymaster cityId;
    @JoinColumn(name = "imageId", referencedColumnName = "imageId")
    @ManyToOne(optional = false)
    private Propertyimages imageId;
    @JoinColumn(name = "stateid", referencedColumnName = "stateId")
    @ManyToOne(optional = false)
    private Statemaster stateid;

    public Propertydetails() {
    }

    public Propertydetails(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Propertydetails(Integer propertyId, String description, String propertyType, double propertyPrice, String status, String address, Date yearBuilt) {
        this.propertyId = propertyId;
        this.description = description;
        this.propertyType = propertyType;
        this.propertyPrice = propertyPrice;
        this.status = status;
        this.address = address;
        this.yearBuilt = yearBuilt;
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

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

//    @JsonbTransient
//    public Collection<Propertyimages> getPropertyimagesCollection() {
//        return propertyimagesCollection;
//    }
//
//    public void setPropertyimagesCollection(Collection<Propertyimages> propertyimagesCollection) {
//        this.propertyimagesCollection = propertyimagesCollection;
//    }

    @JsonbTransient
    public Collection<Transactiondetails> getTransactiondetailsCollection() {
        return transactiondetailsCollection;
    }

    public void setTransactiondetailsCollection(Collection<Transactiondetails> transactiondetailsCollection) {
        this.transactiondetailsCollection = transactiondetailsCollection;
    }

    @JsonbTransient
    public Collection<Feedbackdetails> getFeedbackdetailsCollection() {
        return feedbackdetailsCollection;
    }

    public void setFeedbackdetailsCollection(Collection<Feedbackdetails> feedbackdetailsCollection) {
        this.feedbackdetailsCollection = feedbackdetailsCollection;
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

    public Propertyimages getImageId() {
        return imageId;
    }

    public void setImageId(Propertyimages imageId) {
        this.imageId = imageId;
    }

    public Statemaster getStateid() {
        return stateid;
    }

    public void setStateid(Statemaster stateid) {
        this.stateid = stateid;
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
        return "entity.Propertydetails[ propertyId=" + propertyId + " ]";
    }
    
}
