package com.Dodon.Gatea.Saas.controller;

import com.Dodon.Gatea.Saas.exception.ResourceNotFoundException;
import com.Dodon.Gatea.Saas.model.User;
import com.Dodon.Gatea.Saas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
	    return userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody User userRequest) {

	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userRequest));

	    user.setFirstName(userRequest.getFirstName());
	    user.setLastName(userRequest.getLastName());
	    user.setUsername(userRequest.getUsername());
	    user.setPassword(userRequest.getPassword());
	    user.setRoles(userRequest.getRoles());
	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}

}
