package com.prototype.service.impl;

import static com.prototype.constant.UserImplConstant.EMAIL_ALREADY_EXISTS;
import static com.prototype.constant.UserImplConstant.FOUND_USER_BY_USERNAME;
import static com.prototype.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;
import static com.prototype.constant.UserImplConstant.USERNAME_ALREADY_EXISTS;
import static com.prototype.enumeration.Role.ROLE_SUPER_ADMIN;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prototype.domain.IdentificationTypes;
import com.prototype.domain.User;
import com.prototype.domain.UserPrincipal;
import com.prototype.dto.UserRequestDto;
import com.prototype.enumeration.Role;
import com.prototype.exception.domain.EmailExistException;
import com.prototype.exception.domain.UserNotFoundException;
import com.prototype.exception.domain.UsernameExistException;
import com.prototype.mapper.UserMapper;
import com.prototype.repository.UserRepository;
import com.prototype.service.UserService;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + username);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + username);
        } else {
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            LOGGER.info(FOUND_USER_BY_USERNAME + username);
            return userPrincipal;
        }
    }

    @Override
    public User register(String firstName, String lastName, String username, String email, String institution,Long idIdentificationType) throws UserNotFoundException, UsernameExistException, EmailExistException {
        validateNewUsernameAndEmail(EMPTY, username, email);
        User user = new User();
        user.setUserId(generateUserId());
        String password = generatePassword();
        String encodedPassword = encodePassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setInstitution(institution);
        user.setJoinDate(new Date());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setNotLocked(true);
        user.setRole(ROLE_SUPER_ADMIN.name());
        user.setAuthorities(ROLE_SUPER_ADMIN.getAuthorities());
        user.setProfileImageUrl(getTemporaryProfileImageUrl());
        user.setIdentificationType(new IdentificationTypes(idIdentificationType));
        User userSaved = userRepository.save(user);
        LOGGER.info("New user password: " + password);
        return userSaved;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    private String getTemporaryProfileImageUrl() {
      //  return ServletUriComponentsBuilder.fromCurrentContextPath().path(DEFAULT_USER_IMAGE_PATH).toUriString();
    	return "https://xsgames.co/randomusers/avatar.php?g=pixel";
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }

    private User validateNewUsernameAndEmail(String currentUsername, String newUsername, String newEmail) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User userByNewUsername = findUserByUsername(newUsername);
        User userByNewEmail = findUserByEmail(newEmail);
        if(StringUtils.isNotBlank(currentUsername)) {
            User currentUser = findUserByUsername(currentUsername);
            if(currentUser == null) {
                throw new UserNotFoundException(NO_USER_FOUND_BY_USERNAME + currentUsername);
            }
            if(userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
                throw new UsernameExistException(USERNAME_ALREADY_EXISTS);
            }
            if(userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return currentUser;
        } else {
            if(userByNewUsername != null) {
                throw new UsernameExistException(USERNAME_ALREADY_EXISTS);
            }
            if(userByNewEmail != null) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return null;
        }
    }

	@Override
	public User uploadFile(String username, MultipartFile profileImage) throws IOException {
		String extensionAvaliables[] = {"jpg","png"};
		 File directory = new File(UPLOAD_DIRECTORY);
		    if (! directory.exists()){
		        directory.mkdir();
		    }	    
		    System.out.println("getOriginalFilename : " + profileImage.getOriginalFilename());
		    System.out.println("getContentType : " + profileImage.getContentType());
		    System.out.println("extension "+ FilenameUtils.getExtension(profileImage.getOriginalFilename()));
		    System.out.println("username " + username);
		    String extension = FilenameUtils.getExtension(profileImage.getOriginalFilename());
			Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, username +"."+ extension);
			//TODO si extension es diferente de jpg o png lanzar exception
			if(Files.deleteIfExists(fileNameAndPath) || Files.deleteIfExists(Paths.get(UPLOAD_DIRECTORY, username +"."+ extensionAvaliables[1]))) {
				System.out.println("File Deleted  "+ username);
			}
			Files.write(fileNameAndPath, profileImage.getBytes());
			User user = findUserByUsername(username);
			//TODO poner en  una constante el HOST
			user.setProfileImageUrl("http://localhost:8081/user/profileImage/"+username);
			User userUpdated = userRepository.save(user);
			return userUpdated;

	}

	@Override
	public byte[] getprofileImage(String username) throws IOException {
		String extension = "jpg";
		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, username+"."+extension);
		byte[] picture = Files.readAllBytes(fileNameAndPath);
		if (picture == null) {
			 fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, username+"."+"png");
			 return Files.readAllBytes(fileNameAndPath);
		}
		return picture;
	}

	@Override
	public User add(UserRequestDto user) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
		// TODO validate exists user
		// TODO recibir identificationType and institution
		User userSaved = register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), null,1L);
		uploadFile(user.getUsername(), user.getProfileImage());
		return userSaved;
	}

	@Override
	public User update(UserRequestDto user)
			throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
		User userExits = findUserByUsername(user.getUsername());
		if (userExits != null) {
			System.out.println("User for update exists  : " + user.getUsername());
			userExits.setFirstName(user.getFirstName());
			userExits.setLastName(user.getLastName());
			userExits.setUsername(user.getUsername());
			userExits.setEmail(user.getEmail());
			userExits.setInstitution(user.getInstitution());
			userExits.setActive(user.isActive());
			userExits.setNotLocked(user.isNonLocked());
			userExits.setRole(user.getRole());
			userExits.setAuthorities(Role.valueOf(user.getRole()).getAuthorities());
			userExits.setProfileImageUrl(getTemporaryProfileImageUrl());
			userExits.setIdentificationType(new IdentificationTypes(user.getIdIdentificationType()));
			uploadFile(user.getUsername(), user.getProfileImage());
			User userSaved = userRepository.save(userExits);
			return userSaved;
		}
		return null;
	}

}
