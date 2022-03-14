package com.services.app.infra.repository;

import com.services.app.infra.entity.Category;
import com.services.app.infra.entity.Request;
import com.services.app.infra.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
public interface RequestRepository extends MongoRepository<Request, String> {

    List<Request> findAllByCategory(Category category);

    List<Request> findAllByUser(User user);
}
