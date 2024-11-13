/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.Statemaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@Stateless
public class AdminEJB implements AdminEJBLocal {
    
    @PersistenceContext(unitName="my_per_unit")
    private EntityManager em;

    @Override
    public Collection<Statemaster> getAllStates() {
        return em.createNamedQuery("Statemaster.findAll",Statemaster.class).getResultList();
    }

    @Override
    public void addState(String stateName) {
        Statemaster state = new Statemaster();
        state.setStateName(stateName);
        em.persist(state);
    }
}
