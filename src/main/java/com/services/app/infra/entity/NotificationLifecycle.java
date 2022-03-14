package com.services.app.infra.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "request_notification_lifecycle")
public class NotificationLifecycle {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    private Notification notification;

    @Indexed
    private String notificationId;

    private String previousState;

    private String currentState;

    private Date createdAt;
}
