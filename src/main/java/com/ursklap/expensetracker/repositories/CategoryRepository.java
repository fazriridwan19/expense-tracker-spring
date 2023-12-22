package com.ursklap.expensetracker.repositories;

import com.ursklap.expensetracker.models.Category;
import com.ursklap.expensetracker.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
