package com.services.app.business.controller;

import com.services.app.business.service.RequestService;
import com.services.app.infra.entity.Request;
import com.services.app.infra.model.request.UserRequestDTO;
import com.services.app.infra.model.response.GetUsersRequestResponse;
import com.services.app.infra.model.response.SaveRequestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/request")
public class UserRequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/save")
    public SaveRequestResponse saveRequest(@RequestBody UserRequestDTO request){
        return requestService.saveRequest(request);
    }

    @GetMapping("/{userId}")
    public GetUsersRequestResponse getUsersRequest(@PathVariable String userId){
        return requestService.getUsersRequest(userId);
    }
}
