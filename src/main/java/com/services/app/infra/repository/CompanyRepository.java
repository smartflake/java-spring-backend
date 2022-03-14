package com.services.app.infra.repository;

import com.services.app.infra.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */
public interface CompanyRepository extends MongoRepository<Company,String> {

    Optional<Company> findByEmail(String email);

    Optional<Company> findByCommercialRegister(String commercialRegister);
}
