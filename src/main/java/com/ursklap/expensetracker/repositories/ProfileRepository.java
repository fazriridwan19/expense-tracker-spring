package com.ursklap.expensetracker.repositories;

import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends BaseRepository<Profile, Long> {
}
