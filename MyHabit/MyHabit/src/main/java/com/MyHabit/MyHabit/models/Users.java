package com.MyHabit.MyHabit.models;

import org.hibernate.validator.constraints.URL;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Users {

  // FIELDS
  @Id
  @GeneratedValue
  private int id;
  @NotNull
  private String userName;
  @NotNull
  private String passwordHash;
  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  // merged profile fields
  @Size(min = 1, max = 35)
  private String firstName;

  @Size(min = 1, max = 35)
  private String lastName;

  @Email
  private String email;

  // optional fields
  @Size(min = 1, max = 35)
  private String displayName; // the name a user wants to display on their profile, instead of their first and last names

  @Size(min = 1, max = 35)
  private String location;

  @Size(max = 150)
  private String status;

  @Size(max = 500)
  private String bio;

  @URL
  private String profileImageURL;

  // TABLE RELATIONSHIPS
  @OneToMany(mappedBy = "user") // one user object to many habit objects
  private List<Habit> habits;

  @OneToMany // one user to many habit settings objects
  @JoinColumn(name = "id")
  private List<HabitSettings> habitSettings;

  // CONSTRUCTORS
  public Users() {
  }

  public Users(String uName, String password, String firstName, String lastName, String displayName, String email, String location, String status, String bio, String profileImageURL) {
    this.userName = uName;
    this.passwordHash = encoder.encode(password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.displayName = displayName;
    this.email = email;
    this.location = location;
    this.status = status;
    this.bio = bio;
    this.profileImageURL = profileImageURL;
  }

  // METHODS, GETTERS & SETTERS
  public boolean isMatchingPassword(String password) {
    return encoder.matches(password, passwordHash);
  }

  public String getUserName() {
    return userName;
  }

  public int getId() {
    return id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  //think i know how to fix this
  public void setPasswordHash(String password) {
    this.passwordHash = encoder.encode(password);
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

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public List<Habit> getHabits() {
    return habits;
  }

  public void setHabits(List<Habit> habits) {
    this.habits = habits;
  }

  public List<HabitSettings> getHabitSettings() {
    return habitSettings;
  }

  public void setHabitSettings(List<HabitSettings> habitSettings) {
    this.habitSettings = habitSettings;
  }

  @Override
  public String toString() {
    return "User Information \n" +
      "User Id: " + id + '\n' +
      "Username: " + userName + '\n' +
      "First Name: " + firstName + '\n' +
      "Last Name: " + lastName + '\n' +
      "Display Name: " + displayName + '\n' +
      "Email: " + email + '\n' +
      "Location: " + location + '\n' +
      "Status: " + status + '\n' +
      "Bio: " + bio + '\n' +
      "Profile Image: " + profileImageURL + '\n' +
      "Habits: " + habits + '\n';
  }

}
