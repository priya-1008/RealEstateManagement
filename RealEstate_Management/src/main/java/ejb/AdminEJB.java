/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Areamaster;
import entity.Citymaster;
import entity.Propertyimages;
import entity.Statemaster;
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
    
    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    //All State Methods
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
    
    @Override
    public void deleteState(Integer stateId) {
        Statemaster state = em.find(Statemaster.class, stateId);
        if (state != null) {
            em.remove(state);
        }
    }
    
    @Override
    public void updateState(Integer stateId, String stateName) {
        
    }
    
    @Override
    public Statemaster getStateById(Integer stateId) {
        try {
            return em.createNamedQuery("StateMaster.findByStateId", Statemaster.class)
                    .setParameter("assetId", stateId)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null; // or you could throw an exception or handle it as needed
        }
    }
    
    //All City Methods
    
    @Override
    public Collection<Citymaster> getAllCities() {
        return em.createNamedQuery("Citymaster.findAll", Citymaster.class).getResultList();
    }

    @Override
    public void addCity(String cityName, Integer stateId) {
        Statemaster stateid = (Statemaster) em.find(Statemaster.class, stateId);
        Citymaster city = new Citymaster();
        city.setCityName(cityName);
        city.setStateId(stateid);
        em.persist(city);
    }

    //All Area Methods
    
    @Override
    public Collection<Areamaster> getAllAreas() {
        return em.createNamedQuery("Areamaster.findAll", Areamaster.class).getResultList();
    }

    @Override
    public void addArea(String areaName, Integer cityId) {
        Citymaster cityid = (Citymaster) em.find(Citymaster.class, cityId);
        Areamaster area = new Areamaster();
        area.setAreaName(areaName);
        area.setCityId(cityid);
        em.persist(area);
    }

    //All Propertyimages Methods
    
//    @Override
//    public void addImage(String imageUrl, String description) {
//        Propertyimages image = new Propertyimages();
//        image.setImageUrl(imageUrl);
//        image.setDescription(description);
//        em.persist(image);
//    }
//
//    @Override
//    public Collection<Propertyimages> getAllImages() {
//        return em.createNamedQuery("Propertyimages.findAll",Propertyimages.class).getResultList();
//    }
}
