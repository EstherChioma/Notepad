package com.notepad.application.Notepad.service.user;

import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.LoginDto;
import com.notepad.application.Notepad.dto.UserDto;
import com.notepad.application.Notepad.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepo userRepo;

    public static Optional<User> FindUserbyEmail(String email) {
        return null;
    }


    @Override
    public User addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //@Todo lookup bycrypt and encrpt the password on your db.
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        user = userRepo.save(user);
        return user;
    }

    @Override
    public String login(LoginDto loginDto) {
        //@Todo nice work, there is a bug in this code, try and login with a wrong email... and fix the bug

        User loginUser = userRepo.findUserByEmail(loginDto.getEmail());

        if (loginUser.getPassword().equals(loginDto.getPassword())){

            return  "Hello " + loginUser.getFirstName() + "you have login successfully !!!";
        }
        else{
            return  "Your details does not match any of our records";
        }

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }


//    @Override
//    public User Login() {
//        userRepo.
//        return null;
//    }
}
