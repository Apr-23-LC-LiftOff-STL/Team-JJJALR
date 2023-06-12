package com.MyHabit.MyHabit.services;

import com.MyHabit.MyHabit.exceptions.UserNotFoundException;
import com.MyHabit.MyHabit.models.HabitSettings;
import com.MyHabit.MyHabit.repositories.UserHabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitSettingsService {

  // import the repo - final, so it cannot be reassigned just values updated
  private final UserHabitRepo userHabitRepo;

  // CONSTRUCTOR
  @Autowired
  public HabitSettingsService(UserHabitRepo userHabitRepo) {
    this.userHabitRepo = userHabitRepo;
  }

  // METHODS
  // add entirely new habit settings
  public HabitSettings addHabitSettings(HabitSettings habitSettings, boolean active, boolean complete, boolean hidden) {
    habitSettings.setActive(active);
    habitSettings.setComplete(complete);
    habitSettings.setHidden(hidden);
    return userHabitRepo.save(habitSettings);
  }

  // update existing habit settings
  // TODO: FIGURE OUT UPDATE FUNCTION; currently identical to ADD function
  public HabitSettings updateHabitSettings(HabitSettings habitSettings, boolean active, boolean complete, boolean hidden) {
    habitSettings.setActive(active);
    habitSettings.setComplete(complete);
    habitSettings.setHidden(hidden);
    return userHabitRepo.save(habitSettings);
  }

  // find all habit settings
  public Iterable<HabitSettings> findAllHabitSettings(){
    return userHabitRepo.findAll();
  }

  // find habit settings by id
  public HabitSettings findHabitSettingsById(int id) {
    return userHabitRepo.findHabitSettingsById(id).orElseThrow(() -> new UserNotFoundException("No HabitSettings Found for HabitSettings ID" + id));
  }

  // delete habit settings
  public void deleteHabitSettings(int id) {
    userHabitRepo.deleteHabitSettingsById(id);
  }

}
