/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import Entity.Statemaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface AdminEJBLocal {
    void addState(String stateName);
    public Collection<Statemaster> getAllStates();
}
