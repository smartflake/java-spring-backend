package com.services.app.infra.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "company_request")
public class Request extends BaseEntity {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    private Category category;

    @DBRef
    private User user;

    @NonNull
    private Address address;

    private Date date;

    private Integer numberOfRooms;

    private String purchaseGuarantee;

    private Integer objectArea;

    private String pollution;

    private String[] areas;

    private String extras;

    private Integer distance;

    private String focus;

    private String frequency;

    private Integer discount;

    private Integer reachableFrom;

    private Integer reachableTill;

    private Integer noOfBoxes;

    private String description;

    private String status;

}
