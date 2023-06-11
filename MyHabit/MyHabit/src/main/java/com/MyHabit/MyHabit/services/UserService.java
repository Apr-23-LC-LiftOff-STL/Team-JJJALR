package com.MyHabit.MyHabit.services;

import com.MyHabit.MyHabit.exceptions.UserNotFoundException;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  // add entirely new profile
  public Users addProfile(Users user, String first, String last, String display, String email, String location, String pic, String status, String bio) {
    user.setFirstName(first);
    user.setLastName(last);
    user.setDisplayName(display);
    user.setEmail(email);
    user.setLocation(location);
    user.setProfileImageURL(pic);
    user.setStatus(status);
    user.setBio(bio);
    return userRepo.save(user);
  }

  // update existing profile (personal information ONLY) - needs @PutMapping
  public Users updateProfile(Users user, String first, String last, String display, String email, String location) {
    user.setFirstName(first);
    user.setLastName(last);
    user.setDisplayName(display);
    user.setEmail(email);
    user.setLocation(location);
    return userRepo.save(user);
  }

  // update profile picture - needs @PutMapping
  public Users updateProfilePic(Users user, String pic) {
    user.setProfileImageURL(pic);
    return userRepo.save(user);
  }

  // update status - needs @PutMapping
  public Users updateStatus(Users user, String status) {
    user.setStatus(status);
    return userRepo.save(user);
  }

  // update bio - needs @PutMapping
  public Users updateBio(Users user, String bio) {
    user.setBio(bio);
    return userRepo.save(user);
  }

  // find profile by id
  public Users findUserById(int id) {
    return userRepo.findUsersById(id).orElseThrow(() -> new UserNotFoundException("No Profile Found for UserID " + id));
  }

  // delete profile
  public void deleteUser(int id) {
    userRepo.deleteUsersById(id);
  }

}
