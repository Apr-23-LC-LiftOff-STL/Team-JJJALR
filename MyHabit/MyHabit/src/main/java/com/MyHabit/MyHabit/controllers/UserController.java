package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class UserController {

  private final UserService userService;

  // CONSTRUCTORS
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // METHODS
  // add new profile
  @PostMapping("/add")
  public ResponseEntity<Users> addProfile(@RequestBody Users user) {
    Users newProfile = userService.addProfile(user);
    return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
  }

  // view user's profile
  @GetMapping("/{id}")
  public ResponseEntity<Users> displayUserProfile(@PathVariable("id") int userId) {
    Users user = userService.findUserById(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  // delete user
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") int userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // (POTENTIAL BUTTONS)
  // update profile information
  @PutMapping("/{id}/update/info")
  public ResponseEntity<Users> updateProfile(@RequestBody Users user, @PathVariable("id") int userId) {
    Users updatedProfile = userService.updateProfile(user, userId);
    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
  }

  // update profile picture
  @PutMapping("/{id}/update/picture")
  public ResponseEntity<Users> updatePicture(@RequestBody Users user, @PathVariable("id") int userId) {
    Users newPic = userService.updateProfilePic(user, userId);
    return new ResponseEntity<>(newPic, HttpStatus.OK);
  }

  // update status
  @PutMapping("/{id}/update/status")
  public ResponseEntity<Users> updateStatus(@RequestBody Users user, @PathVariable("id") int userId) {
    Users newStatus = userService.updateStatus(user, userId);
    return new ResponseEntity<>(newStatus, HttpStatus.OK);
  }

  // update profile bio
  @PutMapping("/{id}/update/bio")
  public ResponseEntity<Users> updateBio(@RequestBody Users user, @PathVariable("id") int userId) {
    Users newBio = userService.updateBio(user, userId);
    return new ResponseEntity<>(newBio, HttpStatus.OK);
  }


  // ORIGINAL METHODS - before refactoring to add @PathVariable("id")
//  // add new profile
//  @PostMapping("/add")
//  public ResponseEntity<Users> addProfile(@RequestBody Users user, String first, String last, String display, String email, String location, String pic, String status, String bio) {
//    Users newProfile = userService.addProfile(user, first, last, display, email, location, pic, status, bio);
//    return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
//  }
//
//  // update profile information
//  @PutMapping("/update/info")
//  public ResponseEntity<Users> updateProfile(@RequestBody Users user, String first, String last, String display, String email, String location) {
//    Users updatedProfile = userService.updateProfile(user, first, last, display, email, location);
//    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
//  }
//
//  // update profile picture
//  @PutMapping("/update/picture")
//  public ResponseEntity<Users> updatePicture(@RequestBody Users user, String pic) {
//    Users newPic = userService.updateProfilePic(user, pic);
//    return new ResponseEntity<>(newPic, HttpStatus.OK);
//  }
//
//  // update status
//  @PutMapping("/update/status")
//  public ResponseEntity<Users> updateStatus(@RequestBody Users user, String status) {
//    Users newStatus = userService.updateStatus(user, status);
//    return new ResponseEntity<>(newStatus, HttpStatus.OK);
//  }
//
//  // update profile bio
//  @PutMapping("/update/bio")
//  public ResponseEntity<Users> updateBio(@RequestBody Users user, String bio) {
//    Users newBio = userService.updateBio(user, bio);
//    return new ResponseEntity<>(newBio, HttpStatus.OK);
//  }


// PROFILE ADDED DURING REGISTRATION PROCESS
//  // add new profile
//  @PostMapping("/add")
//  public ResponseEntity<Users> addProfile(@RequestBody Users user, String first, String last, String display, String email, String location, String pic, String status, String bio) {
//    Users newProfile = userService.addProfile(profile, first, last, display, email, location, pic, status, bio);
//    return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
//  }

}
