package com.services.app.infra.model.request;

import com.services.app.infra.model.GenericRequest;
import lombok.*;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */

@Data
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest extends BaseRequest implements GenericRequest {

    private String email;

    private String password;

    @Builder
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
