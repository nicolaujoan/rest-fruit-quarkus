package edu.poniperro;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Fruit extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @Column
    public String description;
}
