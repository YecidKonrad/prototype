package com.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.domain.IdentificationTypes;
import com.prototype.domain.User;
import com.prototype.domain.UserPrincipal;
import com.prototype.dto.UserRequestDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.exception.domain.EmailExistException;
import com.prototype.exception.domain.UserNotFoundException;
import com.prototype.exception.domain.UsernameExistException;
import com.prototype.service.UserService;
import com.prototype.utility.JWTTokenProvider;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = {JWT_TOKEN_HEADER})
@RequestMapping(path = { "/", "/user" })
public class UserController extends ExceptionHandling {
	private AuthenticationManager authenticationManager;
	private UserService userService;
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public UserController(AuthenticationManager authenticationManager, UserService userService,
			JWTTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		authenticate(user.getUsername(), user.getPassword());
		User loginUser = userService.findUserByUsername(user.getUsername());
		UserPrincipal userPrincipal = new UserPrincipal(loginUser);
		HttpHeaders jwtHeader = generateJwtHeader(userPrincipal);
		return new ResponseEntity<>(loginUser, jwtHeader, OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody UserRequestDto user)
			throws UserNotFoundException, UsernameExistException, EmailExistException {
		User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getUsername(),
				user.getEmail(), user.getInstitution(), user.getIdIdentificationType());
		return new ResponseEntity<>(newUser, OK);
	}

	@GetMapping("/username")
	public String getUserNameByToken(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader) {
		return jwtTokenProvider.getSubject(tokenHeader);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), OK);
	}

	private HttpHeaders generateJwtHeader(UserPrincipal user) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
		return headers;
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
//TODO modificar valores del usuario
}
