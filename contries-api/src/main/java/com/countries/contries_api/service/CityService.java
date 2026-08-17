package com.countries.contries_api.service;

import com.countries.contries_api.dto.CityResponse;
import com.countries.contries_api.dto.ErrorResponse;
import com.countries.contries_api.dto.PageResponse;
import com.countries.contries_api.entity.City;
import com.countries.contries_api.entity.Country;
import com.countries.contries_api.exception.GlobalExceptionHandler;
import com.countries.contries_api.exception.ResourceNotFoundException;
import com.countries.contries_api.repository.CityRepository;
import com.countries.contries_api.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    private CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public PageResponse<CityResponse> getCitiesByCountry(Long countryId, Pageable pageable){
        if(!countryRepository.existsById(countryId)){
            throw new ResourceNotFoundException("Country with id " + countryId + " not found");
        }
        Page<City> cities = cityRepository.findByCountryId(countryId, pageable);
        Page<CityResponse> responsePage = cities.map(this::toResponse);

        return PageResponse.from(responsePage);
    };

    public PageResponse<CityResponse> getCitiesByCountryName(String countryName, Pageable pageable) {
        if (countryName == null || countryName.isBlank()) {
            throw new IllegalArgumentException("Country name must be defined");
        }

        String normalizedName = countryName.replace(" ", "").replace("-", "").replace("_", "").trim().toLowerCase();

        if (!countryRepository.existsByNormalizedName(normalizedName)) {
            throw new ResourceNotFoundException("Country with name " + countryName + " not found");
        }

        Page<City> cities = cityRepository.findByCountryNameNormalized(normalizedName, pageable);
        Page<CityResponse> responsePage = cities.map(this::toResponse);

        return PageResponse.from(responsePage);
    }

    public CityResponse getCityById(Long cityId){
        if(!cityRepository.existsById(cityId)){
            throw new ResourceNotFoundException("City not fund with the id: " + cityId);
        }

        City city = cityRepository.getReferenceById(cityId);
        return this.toResponse(city);
    }

    private CityResponse toResponse(City city) {
        return new CityResponse(
                city.getId(),
                city.getName(),
                city.getCountry().getId(),
                city.getCountry().getName(),
                city.getPopulation(),
                city.getArea(),
                city.getZipCodeCentralOffice(),
                city.getDescription()
        );
    }
}
