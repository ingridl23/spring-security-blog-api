package com.ingrid.blogapi.service;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ingrid.blogapi.model.Role;
import com.ingrid.blogapi.model.User;
import com.ingrid.blogapi.repository.IRoleRepository;
import com.ingrid.blogapi.repository.IUserRepository;

import jakarta.annotation.PostConstruct;

/**
 * clase para realizar pruebas de endpoint con un usuario de prueba y chequear que la funcionalidad y la seguridad implementada
 * funcione correctamente siguiendo el orden y el objetivo de negocio o proyecto asociado.
 */
public class DataInitializer {

	private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        if (userRepository.findByUsername("admin").isEmpty()) {

            Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseThrow(() -> new RuntimeException("Role ADMIN no existe"));

            User admin = User.builder()
                    .username("admin")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .enabled(true)
                    .roles(Set.of(adminRole))
                    .build();

            userRepository.save(admin);

            System.out.println("ADMIN CREADO: admin / 1234");
        }
    }
	
	
	
}
