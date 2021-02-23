package com.notepad.application.Notepad.controller;


import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.LoginDto;
import com.notepad.application.Notepad.dto.UserDto;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class userController {

    //@Todo please delete unused instance variables
    UserRepo userRepo;
    UserDto userDto;

    //@Todo please delete this method
    public UserDto userDto() {
        return new UserDto();
    }

    @Autowired
    UserServiceImpl userService;

    //@Todo please delete this instance variable
    User user;

    @PostMapping("/signup")
    public User registration(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);

    }

    @PostMapping("/login")
    public  String loginUser(@RequestBody LoginDto loginDto){
        return  userService.login(loginDto);
    }

    @GetMapping("/{email}")
    public  User getUser( @PathVariable String email){
        return  userService.getUserByEmail(email);
    }
}
