package com.MyHabit.MyHabit.models;

import javax.persistence.*;

@Entity
public class HabitSettings {

  // FIELDS
  @Id
  @GeneratedValue
  private int id;

  // private ??? startDate
  // private ??? endDate
  private boolean active;
  private boolean complete;
  private boolean hidden;

  // table relationships
  @OneToOne // one habit settings object to one habit
  private Habit habit;

//  @OneToMany
//  private List<Habit> habit;

  @OneToOne // one habit settings object to one user
  private Users user;


  // CONSTRUCTORS
  public HabitSettings() {
  }

  public HabitSettings(boolean active, boolean complete, boolean hidden, Habit habit, Users user) {
    this.active = active;
    this.complete = complete;
    this.hidden = hidden;
    this.habit = habit;
    this.user = user;
  }

  // GETTERS & SETTERS
  public int getId() {
    return id;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public boolean isHidden() {
    return hidden;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  public Habit getHabit() {
    return habit;
  }

  public void setHabit(Habit habit) {
    this.habit = habit;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Habit Settings (Id: " + id + ")" + '\n' +
      "User: " + user + '\n' +
      "Habit: " + habit + '\n' +
      "Status:" + '\n' +
      "Active: " + active + '\n' +
      "Complete: " + complete + '\n' +
      "Hidden from Profile: " + hidden + '\n';
  }
}
