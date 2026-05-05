package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ingrid.blogapi.dto.UserRequest;
import com.ingrid.blogapi.model.User;
import com.ingrid.blogapi.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final IUserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(UserRequest request) {
	    User user = User.builder()
	            .username(request.getUsername())
	            .password(passwordEncoder.encode(request.getPassword()))
	            .email(request.getEmail())
	            .build();

	    return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
	return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(Long id, String username, String email, String pass) {
		User user = userRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("User not found"));

		user.setUsername(username);
		user.setEmail(email);
		 if (pass != null && !pass.isBlank()) {
		        user.setPassword(passwordEncoder.encode(pass));
		    }

			    userRepository.save(user);
		
	}
	
	


}
