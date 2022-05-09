package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Legume extends PanacheEntity {
    
    @Column(unique = true)
    public String name;

    @Column
    public String description;
}
