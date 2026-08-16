package com.countries.contries_api.dto;

import com.countries.contries_api.entity.City;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.HQLSelect;

import java.util.List;

@Schema(description = "Reponse of te country information")
public record CountryReponse(

    @Schema(description = "Indentifier of the Country")
    Long id,

    @Schema(description = "Name of the country", example = "Luxembourg")
    String name,

    @Schema(description = "List of the cities", example = "[Diekirch, Weiswampach, Rodange, Ettelbruck]")
    List<City> cities
    ){
}
