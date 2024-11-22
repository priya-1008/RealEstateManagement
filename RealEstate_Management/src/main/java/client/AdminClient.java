/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import java.io.File;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:AdminResource [admin]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author DELL
 */
public class AdminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RealEstate_Management/resources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("admin");
    }

    public <T> T getAllStates(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("states");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getAllCities(GenericType<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path("cities");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getAllAreas(GenericType<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path("areas");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getAllImages(GenericType<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path("images");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    
    public void addStates(Object requestEntity, String stateName) throws ClientErrorException {
            webTarget.path(java.text.MessageFormat.format("addstates/{0}", new Object[]{stateName})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
    
//    public Response deleteState(int stateid) throws ClientErrorException {
//            return webTarget.path("deletestate/{stateid}")
//                .resolveTemplate("id", stateid)
//                .request()
//                .delete();
//        }
    
    public void deleteState(String stateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteproduct/{0}", new Object[]{stateid})).request().delete();
    }

    
    public Response addCity(String cityName, Integer stateId) throws ClientErrorException {
            return webTarget
                    .path(java.text.MessageFormat.format("addcity/{0}/{1}", 
                    new Object[]{cityName, stateId}))
                    .request(MediaType.APPLICATION_JSON)
                    .post(null, Response.class);
    }
    
    public Response addArea(String areaName, Integer cityId) throws ClientErrorException {
            return webTarget
                    .path(java.text.MessageFormat.format("addarea/{0}/{1}",
                    new Object[]{areaName, cityId}))
                    .request(MediaType.APPLICATION_JSON)
                    .post(null,Response.class);
    }
    
//    public String addImage(File file, String description) {
//        try {
//            Client client = ClientBuilder.newClient();
//
//            // Build the multipart request
//            javax.ws.rs.client.Entity<?> entity = Entity.entity(
//                new javax.ws.rs.core.Form()
//                    .param("file", file.getAbsolutePath())
//                    .param("description", description),
//                MediaType.MULTIPART_FORM_DATA
//            );
//
//            Response response = client.target(BASE_URI)
//                                       .path("/uploadImage")
//                                       .request(MediaType.APPLICATION_JSON)
//                                       .post(entity);
//
//            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//                return "Image uploaded successfully";
//            } else {
//                return "Failed to upload image: " + response.readEntity(String.class);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error while uploading image";
//        }
//    }
    
    public void close() {
        client.close();
    }
    
}

