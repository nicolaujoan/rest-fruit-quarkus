package edu.poniperro;

import java.net.URI;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.poniperro.domain.Vegetable;
import edu.poniperro.services.VegetableService;

import java.util.List;
import java.util.Optional;

/**
 * cuidado con el tipo long del id, es el generado por panache
 * recurso: queda clean, el responsable de buscarse o guardarse... es la propia entidad
 */

@Path("vegetable")
public class VegetableResource {

    @Inject
    VegetableService vegetableService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vegetable> getList() {
        return vegetableService.listVegetables();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVegetableById(@PathParam("id") Long id) {
        Optional<Vegetable> vegetable = vegetableService.getVegetableById(id);

        return vegetable.isPresent() ?
            Response.ok(vegetable.get()).build():
            Response.noContent().build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVegetableByName(@PathParam("name") String name) {
        Optional<Vegetable> vegetable = vegetableService.getVegetableByName(name);

        return vegetable.isPresent() ? 
            Response.ok(vegetable.get()).build():
            Response.noContent().build();
    }
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVegetable(Vegetable vegetable) {
        Boolean hasPersisted = vegetableService.addVegetable(vegetable);
        
        return hasPersisted ?
            Response.created(URI.create("/vegetable" + vegetable.id))
                .build():
            Response.status(500).build();
    }
}
