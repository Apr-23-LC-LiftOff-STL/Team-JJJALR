package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface HabitRepo extends CrudRepository<Habit, Integer> {

  void deleteHabitById(int id);

  Optional<Habit> findHabitById(int id); // optional in case no profile w given id
}
