package edu.poniperro;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("fruit")
public class FruitResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> list() {
        return Fruit.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Fruit fruit) {
        fruit.persist();
        return Response.created(URI.create("/fruit" + fruit.id))
            .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Fruit fruit) {
        Fruit.delete("id", fruit.id);
        return Response.status(202, MediaType.APPLICATION_JSON).entity(fruit).build();
    }
}
