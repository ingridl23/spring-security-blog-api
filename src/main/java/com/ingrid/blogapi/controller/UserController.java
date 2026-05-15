package com.ingrid.blogapi.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@PreAuthorize("hasRole('ADMIN')")

public class UserController {
	
	  private final UserServiceImpl UserService;
	
	
	  @PostMapping
	    public User createUser(@RequestBody UserRequest request) {
	        return UserService.createUser(request);
	    }

	  @GetMapping
	    public List<User> getAllUsers() {
	        return UserService.getAllUsers();
	    }
	  
	  @GetMapping("/{id}")
	    public Optional<User> getUserById(@PathVariable Long id) {
	        return UserService.getUserById(id);
	    }
	    
	   @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	    	UserService.deleteUser(id);
	    }
	   
	   @PatchMapping("/{id}")
		  @PreAuthorize("hasAnyRole('ADMIN')")
	   public void updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
		    UserService.updateUser(
		        id,
		        request.getUsername(),
		        request.getEmail(),
		        request.getPassword()
		    );
}
	   
}
