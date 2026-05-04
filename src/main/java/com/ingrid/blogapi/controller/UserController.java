package com.ingrid.blogapi.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ingrid.blogapi.dto.UserRequest;
import com.ingrid.blogapi.model.User;
import com.ingrid.blogapi.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserServiceImpl UserService;
	
	
	
	 @PostMapping
	    public User createPermission(@RequestBody UserRequest request) {
	        return UserService.createUser(request);
	    }

	    @GetMapping
	    public List<User> getAllPermissions() {
	        return UserService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public Optional<User> getPermissionById(@PathVariable Long id) {
	        return UserService.getUserById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePermission(@PathVariable Long id) {
	    	UserService.deleteUser(id);
	    }
}
