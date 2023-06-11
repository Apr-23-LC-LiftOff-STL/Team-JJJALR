package com.MyHabit.MyHabit.repositories;

import org.springframework.data.repository.CrudRepository;
import com.MyHabit.MyHabit.models.Followers;

import java.util.Optional;

public interface FollowerRepo extends CrudRepository<Followers, Integer> {
    Optional<Followers> findByUserId(int userId);

}
