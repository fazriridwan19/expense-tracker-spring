package com.ursklap.expensetracker.models;

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
@Table(name = "profiles")
public class Profile extends BaseEntity {
  @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
  private User user;
  @Column(length = 100, nullable = false)
  private String name;
  @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
  private List<Expense> expenses;
}
