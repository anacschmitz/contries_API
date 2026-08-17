package com.countries.contries_api.repository;

import com.countries.contries_api.entity.City;
import com.countries.contries_api.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findByCountryId(Long countryId, Pageable pageable);
    Page<City> findByCountryName(String countryName, Pageable pageable);

    @Query("SELECT c FROM City c WHERE LOWER(REPLACE(REPLACE(c.country.name, ' ', ''), '-', '')) = LOWER(:normalizedName)")
    Page<City> findByCountryNameNormalized(@Param("normalizedName") String normalizedName, Pageable pageable);

}
