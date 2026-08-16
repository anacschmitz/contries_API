package com.countries.contries_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String name;
    private Long area;
    private Long population;

    @Column(length = 20)
    @Size(max = 5, message = "Zip code must be at most 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9-]*$", message = "Zip code must not contain special characters")
    private String zipCodeCentralOffice;

    @Size(max = 500)
    @Column(length = 500)
    private String description;

    public City() {
    }

    public City(String name, Country country, Long area, Long population, String zipCodeCentralOffice, String description) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.zipCodeCentralOffice = zipCodeCentralOffice;
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

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getZipCodeCentralOffice() {
        return zipCodeCentralOffice;
    }

    public void setZipCodeCentralOffice(String zipCodeCentralOffice) {
        this.zipCodeCentralOffice = zipCodeCentralOffice;
    }




}
