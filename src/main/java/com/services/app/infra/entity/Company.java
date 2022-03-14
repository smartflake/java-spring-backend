package com.services.app.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Document(collection = "company")
public class Company extends BaseEntity {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private String contactNumber;

    @Email
    private String email;

    @Indexed(unique = true)
    private String commercialRegister;

    @JsonIgnore
    private String password;

    private String website;

    private Address address;

    private String idea;

    private Date createdAt;

    private Date updatedAt;

    private Integer amountDue;

    @DBRef
    private Set<CompanyImage> gallery = new HashSet<>();

    @DBRef
    private Set<Request> requests = new HashSet<>();

    @DBRef
    private Set<Review> reviews = new HashSet<>();

    @DBRef
    private Set<Category> categories = new HashSet<>();
}
