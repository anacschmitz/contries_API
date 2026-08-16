package com.countries.contries_api.controller;

import com.countries.contries_api.dto.CountryResponse;
import com.countries.contries_api.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@Tag(name= "countries", description = "Controlers to expose endpoints for Countries information")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    @Operation(summary = "List of all countries", description = "Returns the full list of available countries.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of countries returned successfully")
    })
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

}
