package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {

  Users getByUserName(String userName);
  void deleteUsersById(int id);
  Optional<Users> findUsersById(int id); // optional in case no user w given id
  List<Users> findAll();
}
