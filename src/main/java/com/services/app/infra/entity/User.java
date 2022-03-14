package com.services.app.infra.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User extends BaseEntity{

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String firstname;

    private String lastname;

    @Email
    private String email;

    private String contactNo;

    @DBRef
    private List<Request> requests = new ArrayList<>();

}
