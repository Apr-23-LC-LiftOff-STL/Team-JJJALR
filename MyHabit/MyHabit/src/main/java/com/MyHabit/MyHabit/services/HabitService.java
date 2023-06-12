package com.MyHabit.MyHabit.services;


import com.MyHabit.MyHabit.exceptions.UserNotFoundException;
import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.repositories.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

  // import the repo - final, so it cannot be reassigned just values updated
  private final HabitRepo habitRepo;

  // CONSTRUCTOR
  @Autowired
  public HabitService(HabitRepo habitRepo) {
    this.habitRepo = habitRepo;
  }

  // METHODS
  // add new habit
  public Habit addHabit(Habit habit) {
    // habit.setName(name);
    // habit.setDescription(description);
    return habitRepo.save(habit);
  }

  // update existing habit - needs @PutMapping
  public Habit updateHabit(Habit habit) {
    // habit.setName(name);
    // habit.setDescription(description);
    return habitRepo.save(habit);
  }

  // find habit by id
  public Habit findHabitById(int id) {
    return habitRepo.findHabitById(id).orElseThrow(() -> new UserNotFoundException("No Habit Found for Habit ID" + id));
  }

  // delete habit
  public void deleteHabit(int id) {
    habitRepo.deleteHabitById(id);
  }
}
