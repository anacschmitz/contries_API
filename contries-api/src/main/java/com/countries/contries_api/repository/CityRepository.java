package com.countries.contries_api.repository;

import com.countries.contries_api.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, Long> {
    Page<City> findByCountryId(Long countryId, Pageable pageable);

}
