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

import java.util.List;

/**
 * cuidado con el tipo long del id, es el generado por panache
 * recurso: queda clean, el responsable de buscarse o guardarse... es la propia entidad
 */

@Path("vegetable")
public class VegetableResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vegetable> getList() {
        return Vegetable.findAll().list();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vegetable getVegetableById(@PathParam("id") Long id) {
        return Vegetable.find("id", id).firstResult();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vegetable getVegetableByName(@PathParam("name") String name) {
        return Vegetable.find("name", name).firstResult();
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
