package com.sagittarius.donations.persistance.repository.country;


import com.sagittarius.donations.persistance.domain.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for the Countries extends from Generic CRUD repository,
 * which already contains main methods defined...
 *
 * @author levon
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByName(String name);
}
