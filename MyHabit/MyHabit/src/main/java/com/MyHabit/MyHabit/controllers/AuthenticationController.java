package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.DTO.LoginDTO;
import com.MyHabit.MyHabit.DTO.RegistrationDTO;
import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@RestController
public class AuthenticationController {

    @Autowired
    UserRepo userRepo;

    private static final String userSessionKey = "user";
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //redo


    private static void setUserInSession(HttpSession session, Users user){
        session.setAttribute(userSessionKey, user.getId());
    }

    public Users getUserFromSession(HttpSession session){

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if(userId == null){
            return null;
        }

        Optional<Users> usersOptional = userRepo.findById(userId);

        if (usersOptional.isEmpty()){
            return null;
        }
        return usersOptional.get();
    }

    @PostMapping("/register")
    public String addUsers(@RequestBody RegistrationDTO registrationDTO) {
        Users existingUser = userRepo.getByUserName(registrationDTO.getUserName());
        //placeholder returns
        if (existingUser != null){
            return "login";
        } else {
            if(registrationDTO.verifyPassword(registrationDTO.getPassword(), registrationDTO.getVerifyPassword()) == true) {
                Users newUser = new Users(registrationDTO.getUserName(), registrationDTO.getPassword());

                userRepo.save(newUser);
                return "home";
            } else {
                return "please check your password";
            }
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO){
        Users existingUser = userRepo.getByUserName(loginDTO.getUserName());
        System.out.println("test");
        System.out.println(existingUser);

        if (existingUser == null){

            return "please register first";
        }
        if (existingUser.isMatchingPassword(loginDTO.getPassword())){
            return "login successful";
        } else{
           return "oops";
        }

    }
}
