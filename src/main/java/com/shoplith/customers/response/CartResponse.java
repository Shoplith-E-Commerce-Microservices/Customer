package com.shoplith.customers.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class CartResponse {

   private UUID id;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;



}
