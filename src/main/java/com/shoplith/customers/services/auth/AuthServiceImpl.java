package com.shoplith.customers.services.auth;

import com.shoplith.customers.client.CartClient;
import com.shoplith.customers.dto.UserDto;
import com.shoplith.customers.exceptions.UserAlreadyExistException;
import com.shoplith.customers.mapper.UserMapper;
import com.shoplith.customers.models.Users;
import com.shoplith.customers.payload.AuthPayload;
import com.shoplith.customers.payload.CartPayload;
import com.shoplith.customers.repositories.UserRepository;
import com.shoplith.customers.response.ApiResponse;
import com.shoplith.customers.response.CartResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  private CartClient cartClient;


  public AuthServiceImpl(UserRepository userRepository,CartClient cartClient){
      this.userRepository = userRepository;
      this.cartClient = cartClient;
  }


    @Transactional
    public UserDto signUp(AuthPayload payload){
       if( userRepository.findByEmail(payload.getEmail()).isPresent()){
           throw new UserAlreadyExistException("User already Exist");
       }
       Users newUser = new Users();
       newUser.setEmail(payload.getEmail());
       newUser.setPassword(payload.getPassword());
       newUser.setProviderId(null);
       newUser.setProviderName(null);
       newUser.setUserAddress(null);
       newUser.setIsActive(true);
      Users createdUser =  userRepository.save(newUser);
        CartPayload cartPayload = new CartPayload();
        cartPayload.setUser_id(createdUser.getId());
        ApiResponse<CartResponse> data =  cartClient.createCart(cartPayload);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(data.getData().getId());
        cartResponse.setUpdatedAt(data.getData().getUpdatedAt());
        cartResponse.setCreatedAt(data.getData().getCreatedAt());
       return UserMapper.mapUserToUserDto(createdUser,cartResponse) ;

    }

}
