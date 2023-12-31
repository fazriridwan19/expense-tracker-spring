package com.ursklap.expensetracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ursklap.expensetracker.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {
  @Column(nullable = false, length = 50)
  private String title;
  @Column(columnDefinition = "TEXT")
  private String description;
  private Long amount;
  @ManyToOne
  @JoinColumn(name = "profile")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Profile profile;
}
