/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.AdminClient;
import ejb.AdminEJBLocal;
import entity.Areamaster;
import entity.Citymaster;
import entity.Propertyimages;
import entity.Statemaster;
import java.io.File;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author DELL
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {
    
    @EJB
    AdminEJBLocal aejb;
    private AdminClient adminclient;
    
    private String stateName;
    private String cityName;
    private Integer stateid;
    private String areaName;
    private Integer cityid;
    private String imageUrl;
    private Part file;
    private String description;
    
    Collection<Statemaster> stateList;
    Collection<Citymaster> cityList;
    Collection<Areamaster> areaList;
    Collection<Propertyimages> imageList;
    
    private final GenericType<Collection<Statemaster>> stateGenericType = new GenericType<Collection<Statemaster>>(){};
    private final GenericType<Collection<Citymaster>> cityGenericType = new GenericType<Collection<Citymaster>>(){};
    private final GenericType<Collection<Areamaster>> areaGenericType = new GenericType<Collection<Areamaster>>(){};
//    private final GenericType<Collection<Propertyimages>> imageGenericType = GenericType<Collection<Propertyimages>>(){};

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
    @PostConstruct
    public void init(){
        try{
           adminclient = new AdminClient();
           stateList = adminclient.getAllStates(stateGenericType);
           cityList = adminclient.getAllCities(cityGenericType);
           areaList = adminclient.getAllAreas(areaGenericType);
        }
        catch(ClientErrorException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Collection<Statemaster> getStateList() {
        return stateList;
    }
    
    public Collection<Citymaster> getCityList() {
        return cityList;
    }

    public Collection<Areamaster> getAreaList() {
        return areaList;
    }

    public Collection<Propertyimages> getImageList() {
        return imageList;
    }

//    All Getter Setter Methods
    
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

//    All Add Methods
    
    public void addState(){
        try{
            Statemaster newState = new Statemaster();
            newState.setStateName(stateName);
            adminclient.addStates(newState, stateName);
            stateList = adminclient.getAllStates(stateGenericType);
            stateName = "";
            
        }catch(ClientErrorException e){
            
        }
    }
    
    public void addCity() {
        try {
            adminclient.addCity(cityName, stateid);

            cityList = adminclient.getAllCities(cityGenericType);

            cityName = "";
            stateid = null;
//            String.valueOf(stateid) = null;
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }
    public void addArea() {
        try {
            adminclient.addArea(areaName, cityid);

            areaList = adminclient.getAllAreas(areaGenericType);

            areaName = "";
            cityid = null;
//            String.valueOf(stateid) = null;
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }
    
    //ALL DELETE METHODS
    
//    public void deleteState(int stateid) {
//        try {
//            // Call the deleteAsset method from ManagerClient to delete the asset
//            adminclient.deleteState(stateid);
//
//            // Refresh the asset list after deletion
//            stateList = adminclient.getAllStates(stateGenericType);
//        } catch (ClientErrorException e) {
//            // Log the exception if the deletion fails
//        }
//    }
    
    public String deleteState()
    {
        adminclient.deleteState(String.valueOf(stateid));
        return "state.xhtml";
    }

//    public void addImage() {
//        aejb.addImage(imageUrl, description);
//        imageUrl = "";
//        description = "";
//    }

//    public List<Propertyimages> getImageList() {
//        return propertyImageService.getAllImages();
//    }
    
//    public void upload() {
//        if (file != null) {
//            try {
//                String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
//                File uploadedFile = new File("/images/" + fileName);
//                file.write(uploadedFile.getAbsolutePath());
//
//                // Call AdminClient to send the file to the backend
//                String result = adminclient.addImage(uploadedFile, description);
//
//                FacesContext.getCurrentInstance().addMessage(null,
//                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result));
//            } catch (Exception e) {
//                FacesContext.getCurrentInstance().addMessage(null,
//                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "File upload failed"));
//                e.printStackTrace();
//            }
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "No file selected"));
//        }
//    }
}
