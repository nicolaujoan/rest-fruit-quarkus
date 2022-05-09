package edu.poniperro.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import edu.poniperro.domain.Legume;

@ApplicationScoped
public class LegumeService {
    
    public List<Legume> listLegumes() {
       return Legume.listAll();
    }
}
