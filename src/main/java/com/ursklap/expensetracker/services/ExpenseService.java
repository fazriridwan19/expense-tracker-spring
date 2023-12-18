package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.Expense;
import com.ursklap.expensetracker.services.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService extends BaseService<Expense, Long> {
}
