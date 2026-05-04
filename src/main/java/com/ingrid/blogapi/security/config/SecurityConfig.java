package com.ingrid.blogapi.security.config;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	

    private final JwtFilter jwtFilter;
    private final UserDetailsService userDetailsService;

	   

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        return http
	                .csrf(csrf -> csrf.disable())
	                .sessionManagement(session ->
	                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	                .authorizeHttpRequests(auth -> auth

	                        .requestMatchers("/api/auth/**").permitAll()

	                        .requestMatchers("/api/users/**").hasRole("ADMIN")
	                        .requestMatchers("/api/roles/**").hasRole("ADMIN")
	                        .requestMatchers("/api/permissions/**").hasRole("ADMIN")

	                        .requestMatchers("/api/posts/**").hasAnyRole("ADMIN", "AUTHOR", "USER")

	                        .anyRequest().authenticated()
	                )
	                .authenticationProvider(authenticationProvider())
	                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }
	    
	    
	    
	    
/*
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }

*/
	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

	    return http
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/api/auth/**").permitAll()
	                    .anyRequest().authenticated()
	            )
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	}
	*/
	/*
//dejamos publicos estos endpoints temporalmente para cargar permisos en postman
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

	        return http
	                .csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/api/permissions/**").permitAll()
	                        .requestMatchers("/api/roles/**").permitAll()
	                        .requestMatchers("/api/users/**").permitAll()
	                        .requestMatchers("/api/auth/**").permitAll()
	                        .anyRequest().authenticated()
	                )
	                .httpBasic(Customizer.withDefaults())
	                .build();
	    }
	  */
	  
	  
	  
    //creamos authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    //creamos authentication provider
    //Agregamos el user Details Service como parámetro
    /*@Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        

        return provider;
    }
*/
    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }
    //password encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
    }

}
