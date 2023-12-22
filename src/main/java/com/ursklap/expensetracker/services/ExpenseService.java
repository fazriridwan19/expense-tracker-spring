package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.Expense;
import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.models.User;
import com.ursklap.expensetracker.repositories.ExpenseRepository;
import com.ursklap.expensetracker.services.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService extends BaseService<Expense, Long> {
  private UserService userService;
  private ExpenseRepository expenseRepository;

  @Override
  public Expense create(Expense entity) {
    User currentUser = userService.getCurrentUser();
    entity.setProfile(currentUser.getProfile());
    return super.create(entity);
  }

  @Override
  public List<Expense> getAll() {
    User currentUser = userService.getCurrentUser();
    return currentUser.getProfile().getExpenses();
  }

  @Override
  public Expense getById(Long id) {
    User currentUser = userService.getCurrentUser();
    return expenseRepository
            .findByIdAndProfile(id, currentUser.getProfile())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found for this user"));
  }

  @Override
  public Expense update(Long id, Expense entity) {
    this.getById(id);
    return super.update(id, entity);
  }

  @Override
  public Expense delete(Long id) {
    this.getById(id);
    return super.delete(id);
  }
}
