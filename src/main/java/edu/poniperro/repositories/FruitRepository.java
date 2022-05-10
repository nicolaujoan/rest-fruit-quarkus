package edu.poniperro.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import edu.poniperro.domain.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

/**
 * este es nuestro repository, implementa PanacheRepository
 * colocamos la lógica de las queries en forma de métodos de instancia
 * a diferencia de active record que son estaticos
 */

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {
    
    public List<Fruit> listFruits() {
        return listAll();
    }

    @Transactional
    public void addFruit(Fruit fruit) {
        persist(fruit);
    }

    public void deleteFruit(Long id) {
        delete("id", id);
    }
}
