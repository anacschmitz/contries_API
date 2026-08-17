package com.countries.contries_api.repository;

import com.countries.contries_api.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByName(String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Country c " +
            "WHERE LOWER(REPLACE(REPLACE(c.name, ' ', ''), '-', '')) = LOWER(:normalizedName)")
    boolean existsByNormalizedName(@Param("normalizedName") String normalizedName);

}
