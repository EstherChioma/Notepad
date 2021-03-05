package com.notepad.application.Notepad.controller;


import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.LoginDto;
import com.notepad.application.Notepad.dto.UserDto;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.user.UserAlreadayExistException;
import com.notepad.application.Notepad.service.user.UserService;
import com.notepad.application.Notepad.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/user")
    public ResponseEntity<User> registration(@RequestBody UserDto userDto) throws UserAlreadayExistException {
        User savedUser = userService.save(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public  String loginUser(@RequestBody LoginDto loginDto){
        return  userService.login(loginDto);
    }

    @GetMapping("/users")
    List<User> findAllUsers(){
        return userService.findAllUser();
    }
}
