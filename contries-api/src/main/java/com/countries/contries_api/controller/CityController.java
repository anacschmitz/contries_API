package com.countries.contries_api.controller;

import com.countries.contries_api.dto.CityResponse;
import com.countries.contries_api.dto.ErrorResponse;
import com.countries.contries_api.dto.PageResponse;
import com.countries.contries_api.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@Tag(name= "cities", description = "Controlers to expose endpoints for Cities information")
public class CityController {

        private final CityService cityService;

        public CityController(CityService cityService) {
            this.cityService = cityService;
        }

        @GetMapping("/{countryId}")
        @Operation(summary = "List of all cities", description = "Returns the list of the cities for an specific country" +
                "by its Id value.")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "List of cities returned successfully")
        })
        public ResponseEntity<PageResponse<CityResponse>> getCitiesByCountry(
                @Parameter(description = "Id of the country whose cities should be listed", example = "1")
                @PathVariable Long countryId,
                @Parameter(description = "Pagination parameters: page (zero-based, default 0), size (default 10), sort (e.g. name,asc)")
                @PageableDefault(page = 0, size = 10) Pageable pageable
        ) {
            return ResponseEntity.ok(cityService.getCitiesByCountry(countryId, pageable));
        }

        @GetMapping("/countryName/{countryName}")
        @Operation(summary = "List of all cities", description = "Returns the list of the cities for an specific country name")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "List of cities by country name returned successfully")
        })
        public ResponseEntity<PageResponse<CityResponse>> getCitiesByCountryName(
                @Parameter(description = "Name of the country whose cities should be listed", example = "Luxembourg")
                @PathVariable String countryName,
                @Parameter(description = "Pagination parameters: page (zero-based, default 0), size (default 10), sort (e.g. name,asc)")
                @PageableDefault(page = 0, size = 10) Pageable pageable
        ) {
                return ResponseEntity.ok(cityService.getCitiesByCountryName(countryName, pageable));
        }


        @GetMapping("/detail/{cityId}")
        @Operation(summary = "Get city details by id", description = "Returns the full details of a single city.")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "City found and returned successfully"),
                @ApiResponse(responseCode = "404", description = "City not found",
                        content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
        })
        public ResponseEntity<CityResponse> getCityById(
                @Parameter(description = "Id of the city to search", example = "10")
                @PathVariable Long cityId
        ) {
            return ResponseEntity.ok(cityService.getCityById(cityId));
        }

    }

