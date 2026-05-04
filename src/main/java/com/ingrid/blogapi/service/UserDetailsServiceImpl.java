package com.ingrid.blogapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ingrid.blogapi.model.User;
import com.ingrid.blogapi.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	    private final IUserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    	 User user = userRepository.findByUsername(username)
	    	            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

	    	    return new CustomUserDetails(user);
	    }
	
}
