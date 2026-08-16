package com.countries.contries_api.repository;

import com.countries.contries_api.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
