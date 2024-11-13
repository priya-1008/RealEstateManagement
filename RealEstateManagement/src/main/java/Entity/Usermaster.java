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
@Table(name = "usermaster")
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByUserId", query = "SELECT u FROM Usermaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usermaster.findByUserName", query = "SELECT u FROM Usermaster u WHERE u.userName = :userName"),
    @NamedQuery(name = "Usermaster.findByEmailId", query = "SELECT u FROM Usermaster u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "Usermaster.findByPassword", query = "SELECT u FROM Usermaster u WHERE u.password = :password"),
    @NamedQuery(name = "Usermaster.findByAddress", query = "SELECT u FROM Usermaster u WHERE u.address = :address"),
    @NamedQuery(name = "Usermaster.findByContactNo", query = "SELECT u FROM Usermaster u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "Usermaster.findByCreatedAt", query = "SELECT u FROM Usermaster u WHERE u.createdAt = :createdAt")})
public class Usermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contactNo")
    private long contactNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    @ManyToOne(optional = false)
    private Rolemaster roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Transactiondetails> transactiondetailsCollection;

    public Usermaster() {
    }

    public Usermaster(Integer userId) {
        this.userId = userId;
    }

    public Usermaster(Integer userId, String userName, String emailId, String password, String address, long contactNo, Date createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @JsonbTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public Rolemaster getRoleId() {
        return roleId;
    }

    public void setRoleId(Rolemaster roleId) {
        this.roleId = roleId;
    }
    @JsonbTransient
    public Collection<Transactiondetails> getTransactiondetailsCollection() {
        return transactiondetailsCollection;
    }

    public void setTransactiondetailsCollection(Collection<Transactiondetails> transactiondetailsCollection) {
        this.transactiondetailsCollection = transactiondetailsCollection;
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
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Usermaster[ userId=" + userId + " ]";
    }
    
}
