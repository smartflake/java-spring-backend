package com.services.app.infra.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.app.infra.model.GenericRequest;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class SaveCompanyRequest extends BaseRequest implements GenericRequest {

    private String name;

    private String contactNumber;

    @Email
    private String email;

    @Indexed(unique = true)
    private String commercialRegister;

    @JsonIgnore
    private String password;

    private String website;

    private String addressStreet;

    private String postalCode;

    private String location;

    private String country;
}
