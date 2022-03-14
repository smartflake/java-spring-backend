package com.services.app.infra.repository;

import com.services.app.infra.entity.NotificationLifecycle;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface NotificationLifecycleRepository  extends MongoRepository<NotificationLifecycle , String> {
}
