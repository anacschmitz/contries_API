package com.countries.contries_api.service;

import com.countries.contries_api.dto.CountryResponse;
import com.countries.contries_api.entity.Country;
import com.countries.contries_api.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CountryResponse toResponse(Country country) {
        return new CountryResponse(country.getId(), country.getName());
    }
}
