package com.services.app.infra.repository;

import com.services.app.infra.entity.RequestLifecycle;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface RequestLifecycleRepository extends MongoRepository<RequestLifecycle, String> {
}
