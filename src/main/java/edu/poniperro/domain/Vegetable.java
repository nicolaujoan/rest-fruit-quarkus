package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * we are using the active record pattern with panache, hibernate orm helper
 * note: extending from panache entity
 * ofrece un id por defecto
 * no es necesario getters and setters  
 */

@Entity
public class Vegetable extends PanacheEntity {
    
    @Column(unique = true)
    public String name;

    @Column()
    public String description;

}
