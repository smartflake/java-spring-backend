package com.services.app.infra.repository;

import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.CompanyImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */
public interface CompanyImageRepository extends MongoRepository<CompanyImage, String> {

    List<CompanyImage> findAllByCompany(Company company);
}
