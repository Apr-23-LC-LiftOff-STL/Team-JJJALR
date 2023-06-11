package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.DTO.FollowerDTO;
import com.MyHabit.MyHabit.models.Followers;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.FollowerRepo;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/follow")
public class FollowerController {

  @Autowired
  private FollowerRepo followerRepo;

  @Autowired
  private UserRepo userRepo;

  @GetMapping
  public ResponseEntity getFollowerList(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findByUserId(followerDTO.getUserID());
    Optional<Users> optionalBackupUser = userRepo.findById(followerDTO.getUserID());Followers existingUser = optionalUser.get();
    Users backupUser = optionalBackupUser.get();
    if(optionalUser == null){
      return new ResponseEntity<>(null,HttpStatus.OK);
    }else {
      return new ResponseEntity<>(existingUser.getFollowerList(), HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity addFollower(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findByUserId(followerDTO.getUserID());
    Optional<Users> optionalFollower = userRepo.findById(followerDTO.followerId);
    Optional<Users> optionalBackupUser = userRepo.findUsersById(followerDTO.getUserID());
    if (optionalUser.isPresent()) {
      Followers existingUser = optionalUser.get();
      Users follower = optionalFollower.get();
      System.out.println(follower);
      existingUser.addFollower(follower);
      followerRepo.save(existingUser);
      return new  ResponseEntity<List>(existingUser.getFollowerList(), HttpStatus.OK);
    } else{
      Followers existingUser = new Followers();
      existingUser.setUserId(followerDTO.getUserID());
      Users follower = optionalFollower.get();
      existingUser.addFollower(follower);
      followerRepo.save(existingUser);
      return new  ResponseEntity<List>(existingUser.getFollowerList(), HttpStatus.OK);
   }
  }

  @DeleteMapping
  public ResponseEntity removeFollower(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findByUserId(followerDTO.getUserID());
    Optional<Users> optionalFollower = userRepo.findById(followerDTO.followerId);
    Followers existingUser = optionalUser.get();
    Users follower = optionalFollower.get();
    List currentFollowers = existingUser.getFollowerList();
    if(existingUser.getFollowerList() != null) {
      for (int i = 0; i < existingUser.getFollowerList().size(); i++){
        Users indexUser = (Users) currentFollowers.get(i);
        if (follower.getId() == indexUser.getId()){
          existingUser.getFollowerList().remove(i);
          followerRepo.save(existingUser);
          return new ResponseEntity<String>("done", HttpStatus.OK);
        }

      }
    } return new ResponseEntity<String>("not done", HttpStatus.OK);
  }

}
