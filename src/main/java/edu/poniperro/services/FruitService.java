package edu.poniperro.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

import edu.poniperro.domain.Fruit;
import edu.poniperro.repositories.FruitRepository;

@ApplicationScoped
public class FruitService {
    
    @Inject
    FruitRepository fruitRepository;

    public List<Fruit> listFruits() {
        return fruitRepository.listFruits();
    }

    public Response addFruit(Fruit fruit) {
        fruitRepository.addFruit(fruit);
        return Response.created(URI.create("/fruit" + fruit.getId()))
        .build();
    }

    public List<Fruit> deleteFruitById(Long id) {
        fruitRepository.deleteById(id);
        return this.listFruits();
    }
}
