package com.ursklap.expensetracker.repositories;

import com.ursklap.expensetracker.models.Expense;
import com.ursklap.expensetracker.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long> {
}
