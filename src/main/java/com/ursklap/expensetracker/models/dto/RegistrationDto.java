package com.ursklap.expensetracker.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationDto {
  private String name;
  private String username;
  private String password;
}
