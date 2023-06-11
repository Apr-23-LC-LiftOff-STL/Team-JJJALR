package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import com.MyHabit.MyHabit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class UserController {

  private final UserService userService;

  @Autowired
  private final UserRepo userRepo;

  // CONSTRUCTORS
  public UserController(UserService userService, UserRepo userRepo) {
    this.userService = userService;
    this.userRepo = userRepo;
  }

  // METHODS

  // add/update user profile
  @PutMapping("/edit/{id}")
  public ResponseEntity<Users> updateProfile(@RequestBody Users user, @PathVariable("id") int id) {
    Optional<Users> oldProfile = userRepo.findById(id);
    if (oldProfile.isPresent()) {
      Users newProfile = userRepo.save(user);
      return new ResponseEntity<>(newProfile, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  // view user's profile
  @GetMapping("/{id}")
  public ResponseEntity<Users> displayUserProfile(@PathVariable("id") int userId) {
    Optional<Users> user = userRepo.findById(userId);
    if (user.isPresent()) {
      Users foundUser = user.get();
      return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  // delete user
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") int userId) {
    userRepo.deleteById(userId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // (POTENTIAL BUTTONS)
  // update profile information
//  @PutMapping("/edit/info/{id}")
//  public ResponseEntity<Users> updateProfile(@PathVariable("id") int userId) {
//    Optional<Users> profile = userRepo.findById(userId);
//    if (profile.isPresent()) {
//      Users updatedProfile = profile.get();
//      userRepo.save(updatedProfile);
//      return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
//    }
//    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//  }
//
//  // update profile picture
//  @PutMapping("/edit/pic/{id}")
//  public ResponseEntity<Users> updatePicture(@RequestBody Users user, @PathVariable("id") int userId) {
//    Users newPic = userService.updateProfilePic(user, userId);
//    return new ResponseEntity<>(newPic, HttpStatus.OK);
//  }
//
//  // update status
//  @PutMapping("/edit/status/{id}")
//  public ResponseEntity<Users> updateStatus(@RequestBody Users user, @PathVariable("id") int userId) {
//    Users newStatus = userService.updateStatus(user, userId);
//    return new ResponseEntity<>(newStatus, HttpStatus.OK);
//  }
//
//  // update profile bio
//  @PutMapping("/edit/bio/{id}")
//  public ResponseEntity<Users> updateBio(@RequestBody Users user, @PathVariable("id") int userId) {
//    Users newBio = userService.updateBio(user, userId);
//    return new ResponseEntity<>(newBio, HttpStatus.OK);
//  }


// OLD METHODS
//  @PutMapping("/edit/")
//  public ResponseEntity<Users> updateProfile(@RequestBody Users user) {
//    Users updatedProfile = userRepo.save(user);
//    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
//  }

  // add new profile
//  @PostMapping("/add")
//  public ResponseEntity<Users> addProfile(@RequestBody Users user) {
//    Optional<Users> profile = userRepo.findById(user.getId());
//    if (profile.isPresent()) {
//      Users newProfile = profile.get();
//      userRepo.save(newProfile);
//      return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
//    }
//    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//  }

}
