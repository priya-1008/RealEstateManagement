/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package RestResources;

import EJB.AdminEJBLocal;
import Entity.Statemaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DELL
 */
@Path("Admin")
@RequestScoped
public class AdminResource {

    @EJB
    AdminEJBLocal aejb;
    
    public AdminResource (){
       
    }
    // ===== All State Methods ====== 
    @GET
    @Path("states")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Statemaster> getAllStates(){
       
        return aejb.getAllStates();     
    }
    @POST
    @Path("addstates/{stateName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStates(@PathParam("stateName") String  stateName) {
        aejb.addState(stateName);
    }
}
