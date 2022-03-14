package com.services.app.infra.repository;

import com.services.app.infra.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<Category> findByType(String type);
}
