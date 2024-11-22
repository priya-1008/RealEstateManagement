/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "feedbackdetails")
@NamedQueries({
    @NamedQuery(name = "Feedbackdetails.findAll", query = "SELECT f FROM Feedbackdetails f"),
    @NamedQuery(name = "Feedbackdetails.findByFeedbackId", query = "SELECT f FROM Feedbackdetails f WHERE f.feedbackId = :feedbackId"),
    @NamedQuery(name = "Feedbackdetails.findByDescription", query = "SELECT f FROM Feedbackdetails f WHERE f.description = :description")})
public class Feedbackdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "feedbackId")
    private Integer feedbackId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    @ManyToOne(optional = false)
    private Propertydetails propertyId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;

    public Feedbackdetails() {
    }

    public Feedbackdetails(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Feedbackdetails(Integer feedbackId, String description) {
        this.feedbackId = feedbackId;
        this.description = description;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (feedbackId != null ? feedbackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedbackdetails)) {
            return false;
        }
        Feedbackdetails other = (Feedbackdetails) object;
        if ((this.feedbackId == null && other.feedbackId != null) || (this.feedbackId != null && !this.feedbackId.equals(other.feedbackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Feedbackdetails[ feedbackId=" + feedbackId + " ]";
    }
    
}
