package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.HabitSettings;
import com.MyHabit.MyHabit.repositories.UserHabitRepo;
import com.MyHabit.MyHabit.services.HabitSettingsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitSettings")
public class UserHabitController {

  private final HabitSettingsService habitSettingsService;

//  @Autowired
//  UserHabitRepo userHabitRepo;

  // CONSTRUCTORS
  public UserHabitController(HabitSettingsService habitSettingsService) {
    this.habitSettingsService = habitSettingsService;
  }

  // METHODS
  // view user's settings for a given habit
  @GetMapping("/{id}")
  public ResponseEntity<HabitSettings> displayHabitSettings(@PathVariable("id") int habitSettingsId) {
    HabitSettings habitSettings = habitSettingsService.findHabitSettingsById(habitSettingsId);
    return new ResponseEntity<>(habitSettings, HttpStatus.OK);
  }

  // add habit settings
  @PostMapping("/add")
  public ResponseEntity<HabitSettings> addHabitSettings(@RequestBody HabitSettings habitSettings, boolean active, boolean complete, boolean hidden) {
    HabitSettings newHabitSettings = habitSettingsService.addHabitSettings(habitSettings, active, complete, hidden);
    return new ResponseEntity<>(newHabitSettings, HttpStatus.CREATED);
  }

  // update habit settings
  @PutMapping("/update")
  public ResponseEntity<HabitSettings> updateHabitSettings(@RequestBody HabitSettings habitSettings, boolean active, boolean complete, boolean hidden) {
    HabitSettings updatedHabitSettings = habitSettingsService.updateHabitSettings(habitSettings, active, complete, hidden);
    return new ResponseEntity<>(updatedHabitSettings, HttpStatus.OK);
  }

  // delete habit settings
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteHabitSettings(@PathVariable("id") int habitSettingsId) {
    habitSettingsService.deleteHabitSettings(habitSettingsId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
