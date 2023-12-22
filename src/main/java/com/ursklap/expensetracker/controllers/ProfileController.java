package com.ursklap.expensetracker.controllers;

import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
  private ProfileService profileService;

  @PostMapping
  public ResponseEntity<Profile> create(@RequestBody Profile expenses) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(profileService.create(expenses));
  }

//  @GetMapping
//  public ResponseEntity<Page<Profile>> getAll(ProfileSearchCriteria taskSearchCriteria) {
//    return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(profileService.getAll(taskSearchCriteria));
//  }

  @GetMapping
  public ResponseEntity<List<Profile>> getAll() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(profileService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Profile> getById(@PathVariable Long id) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(profileService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Profile> update(@PathVariable Long id, @RequestBody Profile expenses) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(profileService.update(id, expenses));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Profile> delete(@PathVariable Long id) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(profileService.delete(id));
  }
}
