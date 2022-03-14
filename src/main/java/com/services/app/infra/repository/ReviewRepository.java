package com.services.app.infra.repository;

import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByCompany(Company company);

    Optional<Review> findById(String id);
}
