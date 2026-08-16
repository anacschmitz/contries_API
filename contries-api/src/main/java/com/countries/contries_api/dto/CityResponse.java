package com.countries.contries_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Representation of the City")
public record CityResponse(
        @Schema(description = "Unique identifier of the city")
        Long id,

        @Schema(description = "Name of the city", example= "Troisvierges")
        String name,

        @Schema(description = "ID of the country this city belongs to")
        Long countryId,

        @Schema(description = "Name of the country this city belongs to", example = "Luxembourg")
        String countryName,

        @Schema(description = "Area of the city in square quilometers", example = "37.86")
        Long area,

        @Schema(description = "Number of residents living in the city", example = "3,708")
        Long population,

        @Schema(description = "List of the official zip code registred in the city", example = "[9992, 9993, ...]")
        List<String> zipCode,

        @Schema(description = "A small description of the city with an limit of 500 caracteres", example = "Troisvierges" +
                " (Ëlwen in Luxembourgish) is a " +
                "commune located in northern Luxembourg, in the Ardennes region (Éislek).")
            String description)
{
}
