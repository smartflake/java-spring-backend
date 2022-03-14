package com.services.app.business.controller;

import com.services.app.business.service.UserService;
import com.services.app.infra.model.request.SaveUserRequest;
import com.services.app.infra.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public BaseResponse saveUser(@RequestBody SaveUserRequest request){
        return userService.saveUser(request);
    }

}
