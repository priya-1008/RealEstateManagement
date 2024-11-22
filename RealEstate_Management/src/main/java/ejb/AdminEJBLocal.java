/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Areamaster;
import entity.Citymaster;
import entity.Propertyimages;
import entity.Statemaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface AdminEJBLocal {
    
    //All State Methods
    public Collection<Statemaster> getAllStates();
    void addState(String stateName);
    void deleteState(Integer stateId);
    void updateState(Integer stateId, String stateName);
    Statemaster getStateById(Integer stateId);
    
    //All City Methods
    public Collection<Citymaster> getAllCities();
    void addCity(String cityName, Integer stateId);
    
    //All Area Methods
    public Collection<Areamaster> getAllAreas();
    void addArea(String areaName, Integer cityId);
    
//    //All Property Images Methods
//    void addImage(String imageUrl, String description);
//    Collection<Propertyimages> getAllImages();
    
}
