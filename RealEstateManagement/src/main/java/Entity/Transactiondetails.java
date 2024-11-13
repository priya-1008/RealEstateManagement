/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "transactiondetails")
@NamedQueries({
    @NamedQuery(name = "Transactiondetails.findAll", query = "SELECT t FROM Transactiondetails t"),
    @NamedQuery(name = "Transactiondetails.findByTransactionId", query = "SELECT t FROM Transactiondetails t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transactiondetails.findByTransactionType", query = "SELECT t FROM Transactiondetails t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "Transactiondetails.findByAmount", query = "SELECT t FROM Transactiondetails t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactiondetails.findByTransactionDate", query = "SELECT t FROM Transactiondetails t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transactiondetails.findByTransactionStatus", query = "SELECT t FROM Transactiondetails t WHERE t.transactionStatus = :transactionStatus")})
public class Transactiondetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transactionId")
    private Integer transactionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "transactionType")
    private String transactionType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transactionDate")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "transactionStatus")
    private String transactionStatus;
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    @ManyToOne(optional = false)
    private Propertydetails propertyId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;

    public Transactiondetails() {
    }

    public Transactiondetails(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Transactiondetails(Integer transactionId, String transactionType, double amount, Date transactionDate, String transactionStatus) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Propertydetails getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Propertydetails propertyId) {
        this.propertyId = propertyId;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactiondetails)) {
            return false;
        }
        Transactiondetails other = (Transactiondetails) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Transactiondetails[ transactionId=" + transactionId + " ]";
    }
    
}
