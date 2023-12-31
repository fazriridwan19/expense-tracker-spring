package com.ursklap.expensetracker.repositories;

import com.ursklap.expensetracker.models.Expense;
import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long> {
  Optional<Expense> findByIdAndProfile(Long id, Profile profile);
}
