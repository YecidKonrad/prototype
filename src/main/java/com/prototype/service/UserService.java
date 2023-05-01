package com.prototype.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.prototype.domain.User;
import com.prototype.dto.UserRequestDto;
import com.prototype.exception.domain.EmailExistException;
import com.prototype.exception.domain.UserNotFoundException;
import com.prototype.exception.domain.UsernameExistException;

public interface UserService {

    User register(String firstName, String lastName, String username, String email, String institution, Long idIdentificationType) throws UserNotFoundException, UsernameExistException, EmailExistException;
    
    User add (UserRequestDto user) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;;
   
    User update (UserRequestDto user) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;;
    
    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
    
    User uploadFile(String username, MultipartFile profileImage) throws IOException;
    
    byte[] getprofileImage(String username) throws IOException;
}
