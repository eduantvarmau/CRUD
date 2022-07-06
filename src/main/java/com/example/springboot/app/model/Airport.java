package com.example.springboot.app.model;

import javax.persistence.*;

@Entity
@Table(name= "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airport_id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    public Integer getId() {
        return airport_id;
    }

    public void setId(Integer id) {
        this.airport_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
