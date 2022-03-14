package com.services.app.infra.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.app.infra.entity.Address;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    @NotNull
    private String name;

    @NotNull
    private String contactNumber;

    @Email
    private String email;

    @NotNull
    private String commercialRegister;

    private String password;

    private String website;

   private Address address;
}
