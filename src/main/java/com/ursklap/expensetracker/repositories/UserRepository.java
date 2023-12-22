package com.ursklap.expensetracker.repositories;

import com.ursklap.expensetracker.models.User;
import com.ursklap.expensetracker.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
