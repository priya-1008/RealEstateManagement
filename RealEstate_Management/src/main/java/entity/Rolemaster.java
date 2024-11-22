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
@Table(name = "rolemaster")
@NamedQueries({
    @NamedQuery(name = "Rolemaster.findAll", query = "SELECT r FROM Rolemaster r"),
    @NamedQuery(name = "Rolemaster.findByRoleId", query = "SELECT r FROM Rolemaster r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Rolemaster.findByRoleName", query = "SELECT r FROM Rolemaster r WHERE r.roleName = :roleName")})
public class Rolemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleId")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "roleName")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<Usermaster> usermasterCollection;

    public Rolemaster() {
    }

    public Rolemaster(Integer roleId) {
        this.roleId = roleId;
    }

    public Rolemaster(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonbTransient
    public Collection<Usermaster> getUsermasterCollection() {
        return usermasterCollection;
    }

    public void setUsermasterCollection(Collection<Usermaster> usermasterCollection) {
        this.usermasterCollection = usermasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolemaster)) {
            return false;
        }
        Rolemaster other = (Rolemaster) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rolemaster[ roleId=" + roleId + " ]";
    }
    
}
