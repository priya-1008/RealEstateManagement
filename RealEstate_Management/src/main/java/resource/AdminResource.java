/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package resource;

import ejb.AdminEJBLocal;
import entity.Areamaster;
import entity.Citymaster;
import entity.Propertyimages;
import entity.Statemaster;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author DELL
 */
@Path("admin")
@RequestScoped
public class AdminResource {

    @EJB
    AdminEJBLocal aejb;
    
    public AdminResource() {
    }
    
    //All State Resources
    
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
    
//    @DELETE
//    @Path("deletestate/{stateid}")
//    public Response deleteState(@PathParam("stateid") int stateid) {
//        Statemaster state = aejb.getStateById(stateid);
//        if (state != null) {
//            aejb.deleteState(stateid);
//            return Response.status(Response.Status.NO_CONTENT).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("State not found").build();
//        }
//    }
    
    @DELETE
    @Path("deletestate/{stateid}")
    public void deleteState(@PathParam("stateid") int stateid) {
        aejb.deleteState(stateid);
    }
    
    // All City Resources
    
    @GET
    @Path("cities")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Citymaster> getAllCities(){
       
        return aejb.getAllCities();     
    }
    
    @POST
    @Path("addcity/{cityName}/{stateId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(@PathParam("cityName") String cityName, @PathParam("stateId") Integer stateId) {
        try {
            aejb.addCity(cityName,stateId);
            return Response.status(Response.Status.CREATED).entity("City added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding city: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("areas")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Areamaster> getAllAreas(){
        return aejb.getAllAreas();     
    }
    
    @POST
    @Path("addarea/{areaName}/{cityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addArea(@PathParam("areaName") String areaName, @PathParam("cityId") Integer cityId) {
        try {
            aejb.addArea(areaName,cityId);
            return Response.status(Response.Status.CREATED).entity("Area added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding area: " + e.getMessage()).build();
        }
    }
    
    //All Propertyimages resources
//    @GET
//    @Path("images")
//    public Collection<Propertyimages> getAllImages() {
//        return aejb.getAllImages();
//    }
    
//    private final String uploadDir = "/path/to/upload/directory/"; // Adjust to your server path
//
//    @POST
//    @Path("/uploadImage")
//    public Response addImage(@FormParam("file") Part filePart,
//                                @FormParam("description") String description) {
//        try {
//            // Validate the uploaded file part
//            if (filePart == null || description == null) {
//                return Response.status(Response.Status.BAD_REQUEST)
//                               .entity("File and description are required").build();
//            }
//
//            // Save file to server
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            String filePath = uploadDir + fileName;
//
//            try (InputStream fileInputStream = filePart.getInputStream()) {
//                Files.copy(fileInputStream, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//            }
//
//            // Save file details in database
//            aejb.addImage(filePath, description);
//
//            return Response.ok("Image uploaded successfully").build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                           .entity("Failed to upload image").build();
//        }
//    }
}
