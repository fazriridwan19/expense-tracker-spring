package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.Category;
import com.ursklap.expensetracker.services.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService extends BaseService<Category, Long> {
}
