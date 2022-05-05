package edu.poniperro;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * we are using the active record pattern with panache, hibernate orm helper
 * note: extending from panache entity
 * ofrece un id por defecto
 */

@Entity
public class Vegetable extends PanacheEntity {
    
    @Column(unique = true)
    public String name;

    @Column()
    public String description;

}
