package edu.poniperro.services;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import edu.poniperro.domain.Fruit;

@ApplicationScoped
public class FruitService {
    
    public List<Fruit> listFruits() {
        return Fruit.listAll();
    }

    public Response addFruit(Fruit fruit) {
        fruit.persist();
        return Response.created(URI.create("/fruit" + fruit.id))
        .build();
    }

    public List<Fruit> deleteFruitById(Long id) {
        Fruit.deleteById(id);
        return this.listFruits();
    }
}
