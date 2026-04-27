package com.shoplith.customers.services.auth;

import com.shoplith.customers.dto.UserDto;
import com.shoplith.customers.payload.AuthPayload;

public interface AuthService {


    public UserDto signUp(AuthPayload payload);


}
