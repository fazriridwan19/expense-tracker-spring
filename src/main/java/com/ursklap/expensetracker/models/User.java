package com.ursklap.expensetracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ursklap.expensetracker.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @OneToOne
  @MapsId
  @JoinColumn(name = "profile")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Profile profile;
  @Column(length = 50, nullable = false, unique = true)
  private String username;
  @Column(columnDefinition = "TEXT", nullable = false)
  private String password;
  private Boolean isEnable = false;
}
