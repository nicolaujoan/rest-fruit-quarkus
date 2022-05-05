package edu.poniperro;

import java.net.URI;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * cuidado con el tipo long del id, es el generado por panache
 * recurso: queda clean, el responsable de buscarse o guardarse... es la propia entidad
 */

@Path("vegetable")
public class VegetableResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vegetable getVegetableById(@PathParam("id") Long id) {
        return Vegetable.find("id", id).firstResult();
    }
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVegetable(Vegetable vegetable) {
        vegetable.persist();
        return Response.created(URI.create("/vegetable" + vegetable.id))
            .build();
    }
}
