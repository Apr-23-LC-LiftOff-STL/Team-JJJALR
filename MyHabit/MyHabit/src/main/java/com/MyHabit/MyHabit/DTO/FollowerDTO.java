package com.MyHabit.MyHabit.DTO;

public class FollowerDTO {

  //returns zero for some reason
  public int userId;

  public int followerId;

  public int getUserID() {
    return userId;
  }

  public void setUserID(int userID) {
    this.userId = userID;
  }

  public int getFollowerId() {
    return followerId;
  }

  public void setFollowerId(int followerId) {
    this.followerId = followerId;
  }
}
