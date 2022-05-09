package edu.poniperro.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import edu.poniperro.domain.Vegetable;

@ApplicationScoped
public class VegetableService {
    
    public List<Vegetable> listVegetables() {
        return Vegetable.listAll();
    }

    public Optional<Vegetable> getVegetableById(Long id) {
        return Vegetable.findByIdOptional(id);
    }

    public Optional<Vegetable> getVegetableByName(String name) {
        return Vegetable.find("name", name).firstResultOptional();
    }

    public Boolean addVegetable(Vegetable vegetable) {
        if (vegetable.isPersistent()) {
            vegetable.persist();
            return true;
        }
        return false;
    }
}
