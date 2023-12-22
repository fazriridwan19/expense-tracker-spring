package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.services.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileService extends BaseService<Profile, Long> {
}
