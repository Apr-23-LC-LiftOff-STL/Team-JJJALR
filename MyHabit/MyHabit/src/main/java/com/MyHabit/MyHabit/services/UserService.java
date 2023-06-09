package com.MyHabit.MyHabit.services;

import com.MyHabit.MyHabit.exceptions.UserNotFoundException;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  // import the repo - final, so it cannot be reassigned just values updated
  private final UserRepo userRepo;

  // CONSTRUCTOR
  @Autowired
  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  // METHODS
  // add entirely new profile - certain fields are specified in order to prevent user from accessing all data associated with user objects
  public Users addProfile(Users user) {
    Users newProfile = findUserById(user.getId());
    newProfile.setFirstName(user.getFirstName());
    newProfile.setLastName(user.getLastName());
    newProfile.setDisplayName(user.getDisplayName());
    newProfile.setEmail(user.getEmail());
    newProfile.setLocation(user.getLocation());
    newProfile.setProfileImageURL(user.getProfileImageURL());
    newProfile.setStatus(user.getStatus());
    newProfile.setBio(user.getBio());
    return userRepo.save(newProfile);
  }

  // update existing profile (personal information ONLY) - needs @PutMapping
  public Users updateProfile(Users user, int id) {
    // initialize new Users object to hold a user's new profile settings
    // use findUserById() service method uses provided id parameter to retrieve user's profile data
    Users updatedProfile = findUserById(id);
    // getters retrieve the user's current settings and setters set the new values
    updatedProfile.setFirstName(user.getFirstName());
    updatedProfile.setLastName(user.getLastName());
    updatedProfile.setDisplayName(user.getDisplayName());
    updatedProfile.setEmail(user.getEmail());
    updatedProfile.setLocation(user.getLocation());
    // save updated information to repo
    return userRepo.save(updatedProfile);
  }

  // update profile picture - needs @PutMapping
  public Users updateProfilePic(Users user, int id) {
    Users updatedPic = findUserById(id);
    updatedPic.setProfileImageURL(user.getProfileImageURL());
    return userRepo.save(updatedPic);
  }

  // update status - needs @PutMapping
  public Users updateStatus(Users user, int id) {
    Users updatedStatus = findUserById(id);
    updatedStatus.setStatus(user.getStatus());
    return userRepo.save(updatedStatus);
  }

  // update bio - needs @PutMapping
  public Users updateBio(Users user, int id) {
    Users updatedBio = findUserById(id);
    updatedBio.setBio(user.getBio());
    return userRepo.save(updatedBio);
  }

  // MODIFIED REPO METHODS
  // TODO: implement this method somewhere (not UserController because routing is to "/profile"), so it can be used to search for all users
  // find all users
  public List<Users> findAllUsers() {
    return userRepo.findAll();
  }

  // find user by id
  public Users findUserById(int id) {
    return userRepo.findUsersById(id).orElseThrow(() -> new UserNotFoundException("No Profile Found for UserID " + id));
  }

  // delete profile
  public void deleteUser(int id) {
    userRepo.deleteUsersById(id);
  }

  // ORIGINAL UPDATE METHODS - before refactoring to minimize parameters, add path variables in controller
//  // add entirely new profile - certain fields are specified in order to prevent user from accessing all data associated with user objects
//  public Users addProfile(Users user, String first, String last, String display, String email, String location, String pic, String status, String bio) {
//    user.setFirstName(first);
//    user.setLastName(last);
//    user.setDisplayName(display);
//    user.setEmail(email);
//    user.setLocation(location);
//    user.setProfileImageURL(pic);
//    user.setStatus(status);
//    user.setBio(bio);
//    return userRepo.save(user);
//  }
//
//  // update existing profile (personal information ONLY) - needs @PutMapping
//  public Users updateProfile(Users user, String first, String last, String display, String email, String location) {
//    user.setFirstName(first);
//    user.setLastName(last);
//    user.setDisplayName(display);
//    user.setEmail(email);
//    user.setLocation(location);
//    return userRepo.save(user);
//  }
//
//  // update profile picture - needs @PutMapping
//  public Users updateProfilePic(Users user, String pic) {
//    user.setProfileImageURL(pic);
//    return userRepo.save(user);
//  }
//
//  // update status - needs @PutMapping
//  public Users updateStatus(Users user, String status) {
//    user.setStatus(status);
//    return userRepo.save(user);
//  }
//
//  // update bio - needs @PutMapping
//  public Users updateBio(Users user, String bio) {
//    user.setBio(bio);
//    return userRepo.save(user);
//  }

}
