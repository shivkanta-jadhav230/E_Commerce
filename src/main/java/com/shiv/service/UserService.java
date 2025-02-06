package com.shiv.service;

import com.shiv.model.User;
import java.util.List;

public interface UserService {

	String signup(User user);

	String login(String email, String password);

	List<User> getAllUsers();

	String updateUser(Long id, User user);

	String deleteUser(Long id);
}
