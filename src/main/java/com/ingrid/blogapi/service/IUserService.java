package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;

import com.ingrid.blogapi.dto.UserRequest;
import com.ingrid.blogapi.model.User;

public interface IUserService {
	 User createUser(UserRequest request);

	    List<User> getAllUsers();

	    Optional<User> getUserById(Long id);

	    void deleteUser(Long id);
}
