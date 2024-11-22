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
import javax.persistence.Lob;
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
@Table(name = "propertyimages")
@NamedQueries({
    @NamedQuery(name = "Propertyimages.findAll", query = "SELECT p FROM Propertyimages p"),
    @NamedQuery(name = "Propertyimages.findByImageId", query = "SELECT p FROM Propertyimages p WHERE p.imageId = :imageId"),
    @NamedQuery(name = "Propertyimages.findByImageUrl", query = "SELECT p FROM Propertyimages p WHERE p.imageUrl = :imageUrl")})
public class Propertyimages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imageId")
    private Integer imageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imageUrl")
    private String imageUrl;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;

    public Propertyimages() {
    }

    public Propertyimages(Integer imageId) {
        this.imageId = imageId;
    }

    public Propertyimages(Integer imageId, String imageUrl, String description) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageId != null ? imageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyimages)) {
            return false;
        }
        Propertyimages other = (Propertyimages) object;
        if ((this.imageId == null && other.imageId != null) || (this.imageId != null && !this.imageId.equals(other.imageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertyimages[ imageId=" + imageId + " ]";
    }
    
}
