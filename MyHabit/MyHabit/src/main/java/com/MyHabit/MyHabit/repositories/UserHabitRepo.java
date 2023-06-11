package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.HabitSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserHabitRepo extends CrudRepository<HabitSettings, Integer> {
  void deleteHabitSettingsById(int id);

  Optional<HabitSettings> findHabitSettingsById(int id); // optional in case no profile w given id
}
