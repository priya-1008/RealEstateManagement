/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBeans;

import Client.AdminClient;
import Entity.Statemaster;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author DELL
 */
@Named(value = "adminManageBeans")
@SessionScoped
public class AdminManageBeans  implements Serializable{
    private AdminClient adminclient;
    private Collection<Statemaster> stateList;
    
    private String stateName;
    private final GenericType<Collection<Statemaster>> stateGenericType = new GenericType<Collection<Statemaster>>(){};
    public AdminManageBeans() {
//        client = new AdminClient();
    }
    @PostConstruct
    public void init(){
        try{
           adminclient = new AdminClient();
           stateList = adminclient.getAllStates(stateGenericType);
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

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
