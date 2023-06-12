package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.repositories.HabitRepo;
import com.MyHabit.MyHabit.services.HabitService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/habit")
public class HabitController {

  private final HabitService habitService;

  // CONSTRUCTORS
  public HabitController(HabitService habitService) {
    this.habitService = habitService;
  }

  // METHODS
  // add new habit
  @PostMapping("/add")
  public ResponseEntity<Habit> addHabit(@RequestBody Habit habit) {
    Habit newHabit = habitService.addHabit(habit);
    return new ResponseEntity<>(newHabit, HttpStatus.CREATED);
  }

  // update habit
  @PutMapping("/update")
  public ResponseEntity<Habit> updateHabit(@RequestBody Habit habit) {
    Habit updatedHabit = habitService.updateHabit(habit);
    return new ResponseEntity<>(updatedHabit, HttpStatus.OK);
  }

  // view habit by id
  @GetMapping("/{id}")
  public ResponseEntity<Habit> viewHabit(@PathVariable("id") int habitId) {
    Habit habit = habitService.findHabitById(habitId);
    return new ResponseEntity<>(habit, HttpStatus.OK);
  }

  // delete habit by id
  @DeleteMapping("delete/{id}")
  public ResponseEntity<?> deleteHabit(@PathVariable("id") int habitId) {
    habitService.deleteHabit(habitId);
    return new ResponseEntity<>(HttpStatus.OK);
  }


//  @Autowired
//  HabitRepo habitRepo;
//
//  @GetMapping
//  @ResponseBody
//  public String sayHello() {
//    return "Habit hello!";
//  }
//
//  @RequestMapping(value = "/add", method = RequestMethod.POST)
//  public Habit addHabit(@RequestBody Habit habit) {
//    Habit newHabit = habitRepo.save(habit);
//    return newHabit;
//  }
//
//  @DeleteMapping("/delete/{id}")
//  public Boolean deleteHabit(@PathVariable("id") int id) {
//    if (!habitRepo.findById(id).equals(Optional.empty())) {
//      habitRepo.deleteById(id);
//      return true;
//    }
//    return false;
//  }
}
