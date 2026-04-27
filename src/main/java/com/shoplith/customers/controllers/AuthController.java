package com.shoplith.customers.controllers;

import com.shoplith.customers.dto.UserDto;
import com.shoplith.customers.payload.AuthPayload;
import com.shoplith.customers.response.ApiResponse;
import com.shoplith.customers.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {


    private final AuthService  authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserDto>> signupController( @RequestBody AuthPayload payload){
        ApiResponse<UserDto> response = new ApiResponse<UserDto>(201,"Signup Successfully", ApiResponse.Status.SUCCESS,authService.signUp(payload));
        response.setStatus(ApiResponse.Status.SUCCESS);return ResponseEntity.status(response.getCode()).body(response);
    }






}
