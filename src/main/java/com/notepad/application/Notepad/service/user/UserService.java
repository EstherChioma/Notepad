package com.notepad.application.Notepad.service.user;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.LoginDto;
import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.dto.UserDto;

import java.util.List;

public interface UserService {


    User save(UserDto userDto) throws UserAlreadayExistException;

    List<User> findAllUser();

    String login(LoginDto loginDto);

}
