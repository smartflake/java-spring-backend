package com.services.app.infra.repository;

import com.services.app.infra.entity.Notification;
import com.services.app.infra.entity.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface NotificationRepository extends MongoRepository<Notification , String> {

    Optional<Notification> findAllByRequest(Request request);

    List<Notification> findAllByStatus(String status);
}
