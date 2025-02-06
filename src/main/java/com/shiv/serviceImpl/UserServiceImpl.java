package com.shiv.serviceImpl;

import com.shiv.model.User;
import com.shiv.repository.UserRepository;
import com.shiv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// Signup Method
	@Override
	public String signup(User user) {
		userRepository.save(user);
		return "User registered successfully.";
	}

	// Login Method
	@Override
	public String login(String email, String password) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		if (user.isPresent()) {
			return "Login successful.";
		} else {
			return "Invalid credentials.";
		}
	}

	// Get All Users Method
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Update User Method
	@Override
	public String updateUser(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setName(user.getName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPassword(user.getPassword());
			userRepository.save(updatedUser);
			return "User updated successfully.";
		}
		return "User not found.";
	}

	// Delete User Method
	@Override
	public String deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.delete(user.get());
			return "User deleted successfully.";
		}
		return "User not found.";
	}
}
