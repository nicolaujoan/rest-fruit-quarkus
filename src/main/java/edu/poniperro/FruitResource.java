package edu.poniperro;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.poniperro.domain.Fruit;
import edu.poniperro.services.FruitService;

import java.util.List;

@Path("fruit")
public class FruitResource {

    @Inject
    FruitService fruitService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> list() {
        return fruitService.listFruits();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Fruit fruit) {
        return fruitService.addFruit(fruit);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        fruitService.deleteFruitById(id);
        return Response.status(202).build();
    }
}
