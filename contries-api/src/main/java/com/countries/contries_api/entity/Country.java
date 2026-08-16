package com.countries.contries_api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public Country(){};
    public Country(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country")

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
