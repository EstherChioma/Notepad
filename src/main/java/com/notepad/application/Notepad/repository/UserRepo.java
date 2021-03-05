package com.notepad.application.Notepad.repository;

import com.notepad.application.Notepad.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo  extends JpaRepository<User, Long> {

      User findUserByEmail(String email);

      User findUserById(Long id);

}
