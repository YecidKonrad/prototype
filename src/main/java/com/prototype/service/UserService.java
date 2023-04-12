package com.prototype.service;

import java.util.List;

import com.prototype.domain.User;
import com.prototype.exception.domain.EmailExistException;
import com.prototype.exception.domain.UserNotFoundException;
import com.prototype.exception.domain.UsernameExistException;

public interface UserService {

    User register(String firstName, String lastName, String username, String email, String institution, Long idIdentificationType) throws UserNotFoundException, UsernameExistException, EmailExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
