package com.services.app.infra.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "company_image")
public class CompanyImage extends BaseEntity{

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    private Company company;
}
