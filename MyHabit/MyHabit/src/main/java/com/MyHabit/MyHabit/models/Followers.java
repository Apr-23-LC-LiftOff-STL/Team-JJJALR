package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Followers {

  @Id
  @GeneratedValue
  private int id;

  //many users to many followlists
  @ManyToMany
  @JoinColumn(name = "followerList")
  private List<Users> usersList;


  private int userId;

  public Followers(){
    this.usersList = new ArrayList<>();
  }

  public List<Users> getFollowerList() {
    return usersList;
  }
  public void addFollower(Users follower){
   usersList.add(follower);
    return;
  }

  public int getId(){return id;}

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
