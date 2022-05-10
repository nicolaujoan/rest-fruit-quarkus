package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * como usamos el patrón reposiitory, usamos las anotaciones para el id
 * los atributos los mantenemos privados
 * hint: podemos extender de PanacheEntityBase para evitar getters and setters e incluso
 * de PanacheEntity para tener un id autogenerado
 */


@Entity
public class Fruit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    public Fruit() {} // hibernate needs it

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
