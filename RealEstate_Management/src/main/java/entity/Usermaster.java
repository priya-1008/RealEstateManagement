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
@Table(name = "usermaster")
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByUserId", query = "SELECT u FROM Usermaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usermaster.findByUserName", query = "SELECT u FROM Usermaster u WHERE u.userName = :userName"),
    @NamedQuery(name = "Usermaster.findByContactNo", query = "SELECT u FROM Usermaster u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "Usermaster.findByAddress", query = "SELECT u FROM Usermaster u WHERE u.address = :address"),
    @NamedQuery(name = "Usermaster.findByEmail", query = "SELECT u FROM Usermaster u WHERE u.email = :email"),
    @NamedQuery(name = "Usermaster.findByPassword", query = "SELECT u FROM Usermaster u WHERE u.password = :password"),
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
    @Column(name = "contactNo")
    private long contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    @ManyToOne(optional = false)
    private Rolemaster roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Transactiondetails> transactiondetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Feedbackdetails> feedbackdetailsCollection;

    public Usermaster() {
    }

    public Usermaster(Integer userId) {
        this.userId = userId;
    }

    public Usermaster(Integer userId, String userName, long contactNo, String address, String email, String password, Date createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.contactNo = contactNo;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @JsonbTransient
    public Collection<Feedbackdetails> getFeedbackdetailsCollection() {
        return feedbackdetailsCollection;
    }

    public void setFeedbackdetailsCollection(Collection<Feedbackdetails> feedbackdetailsCollection) {
        this.feedbackdetailsCollection = feedbackdetailsCollection;
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
        return "entity.Usermaster[ userId=" + userId + " ]";
    }
    
}
