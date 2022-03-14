package com.services.app.infra.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

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
@Document(collection = "request_notification")
public class Notification extends BaseEntity{

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    private Request request;

    @DBRef
    private List<Company> companies = new ArrayList<>();

    private String status;

}
