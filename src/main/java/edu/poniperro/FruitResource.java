package edu.poniperro;

import java.util.Set;
import java.util.LinkedHashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/fruits")
public class FruitResource {
    
    private Set<Fruit> fruits = new LinkedHashSet<Fruit>();

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Mango", "Tropical fruit"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Fruit> list() {
        return fruits;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Fruit fruit) {
        fruits.add(fruit);
        return Response.status(201, MediaType.APPLICATION_JSON).entity(fruits).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Fruit fruit) {
        fruits.remove(fruit);
        return Response.status(202, MediaType.APPLICATION_JSON).entity(fruits).build();
    }
}
