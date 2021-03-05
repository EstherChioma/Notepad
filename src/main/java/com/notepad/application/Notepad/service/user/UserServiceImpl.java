package com.notepad.application.Notepad.service.user;

import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.LoginDto;
import com.notepad.application.Notepad.dto.UserDto;
import com.notepad.application.Notepad.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepo userRepo;


    @Override
    public User save(UserDto userDto) throws UserAlreadayExistException {

        User savedUser;

        User existingUser = userRepo.findUserByEmail(userDto.getEmail());

        log.info("the user you are trying to save------{}", existingUser);

        if(existingUser == null){
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setPhoneNumber(userDto.getPhoneNumber());

             savedUser = userRepo.save(user);
        } else {
            throw new UserAlreadayExistException("Error: user email already exist in database");
        }
        return savedUser;
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public String login(LoginDto loginDto) {

        User loginUser = userRepo.findUserByEmail(loginDto.getEmail());

        if (loginUser.getPassword().equals(loginDto.getPassword())){

            return  "Hello " + loginUser.getFirstName() + "you have login successfully !!!";
        }
        else{
            return  "Your details does not match any of our records";
        }

    }


}
