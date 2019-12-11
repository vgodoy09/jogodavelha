package com.jogadavelha.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogadavelha.exception.ResourceNotFoundException;
import com.jogadavelha.model.User;
import com.jogadavelha.model.auth.LoginUser;
import com.jogadavelha.model.auth.TokenRequest;
import com.jogadavelha.model.auth.response.AuthResponse;
import com.jogadavelha.model.auth.response.UserContext;
import com.jogadavelha.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	UserRepository userRepository;
	
	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}
	
	// Create a new User
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User User) {
	    return userRepository.save(User);
	}
	
	// Get a Single User
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
	
	// Update a User
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody User userDetails) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    user.setLogin(userDetails.getLogin());
	    user.setPassword(userDetails.getPassword());

	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	// Delete a User
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("login")
	public AuthResponse login(@RequestBody LoginUser loginUser) {
		User logged = userRepository.logged(loginUser.getUserName(), loginUser.getPassword());
		
		System.out.println(loginUser.getUserName());
		System.out.println(loginUser.getPassword());
		
		//pega objeto departamento
		UserContext userContext = null;
			userContext = new UserContext(logged.getId(), logged.getLogin());

		return logged == null ? 
				    new AuthResponse(null,"Usuário ou Senha Inválido!", null, true) : 
					new AuthResponse(logged.getPassword(), null, userContext, false);
	}
	
	@PostMapping("checkLogged")
	public AuthResponse checkLogged(@RequestBody TokenRequest tokenRequest) {
		User checkToken = userRepository.logged(tokenRequest.getLogin(), tokenRequest.getToken());
		//pega objeto departamento
		UserContext userContext = new UserContext(checkToken.getId(), checkToken.getLogin());

		return checkToken == null ? 
				new AuthResponse(null, "Token inválido", null, true) : 
					new AuthResponse(null, null, userContext, false);	
	}

}
