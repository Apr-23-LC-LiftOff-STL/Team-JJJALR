package com.MyHabit.MyHabit.DTO;

public class RegistrationDTO {
  private String userName;

  private String password;

  private String secondPassword;

  // profile fields
  private String firstName;
  private String lastName;
  private String displayName;
  private String email;
  private String location;
  private String status;
  private String bio;
  private String profileImageURL;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSecondPassword() {
    return secondPassword;
  }

  public void setPasswordVerification(String verifyPassword) {
    this.secondPassword = secondPassword;
  }

  public boolean verifyPassword(String password, String passwordVerification) {

    if (password == passwordVerification) {
      return true;
    } else {
      return false;
    }

  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getProfileImageURL() {
    return profileImageURL;
  }

  public void setProfileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
  }
}
