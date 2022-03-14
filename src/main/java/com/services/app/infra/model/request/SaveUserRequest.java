package com.services.app.infra.model.request;

import com.services.app.infra.entity.Address;
import com.services.app.infra.model.GenericRequest;
import lombok.*;

import javax.validation.constraints.Email;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class SaveUserRequest extends BaseRequest implements GenericRequest {

    private String firstname;

    private String lastname ;

    @Email
    private String email;

    private String contactNo;


    @Builder
    public SaveUserRequest(String firstname, String lastname, @Email String email, String contactNo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contactNo = contactNo;
    }
}
