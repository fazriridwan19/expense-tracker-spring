package com.ursklap.expensetracker.controllers;

import com.ursklap.expensetracker.models.Expense;
import com.ursklap.expensetracker.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {
  private ExpenseService expenseService;

  @PostMapping
  public ResponseEntity<Expense> create(@RequestBody Expense expenses) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseService.create(expenses));
  }

//  @GetMapping
//  public ResponseEntity<Page<Expense>> getAll(ExpenseSearchCriteria taskSearchCriteria) {
//    return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(expenseService.getAll(taskSearchCriteria));
//  }

  @GetMapping
  public ResponseEntity<List<Expense>> getAll() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Expense> getById(@PathVariable Long id) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Expense> update(@PathVariable Long id, @RequestBody Expense expenses) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseService.update(id, expenses));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Expense> delete(@PathVariable Long id) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseService.delete(id));
  }
}
