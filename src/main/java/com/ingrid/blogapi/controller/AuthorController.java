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
import com.ingrid.blogapi.dto.AuthorRequest;
import com.ingrid.blogapi.model.Author;
import com.ingrid.blogapi.service.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/authors")
@RequiredArgsConstructor
public class AuthorController {

	  private final AuthorServiceImpl  authorService;
	

	  @PostMapping
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR')")
	    public Author createAuthor(@RequestBody AuthorRequest request) {
	        return authorService.createAuthor(request);
	    }

	  @GetMapping
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR','USER')")
	    public List<Author> getAllAuthors() {
	        return authorService.getAllAuthors();
	    }
	  
	  @GetMapping("/{id}")
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR','USER')")
	    public Optional<Author> getAuthorById(@PathVariable Long id) {
	        return authorService.getAuthorById(id);
	    }
	    
	   @DeleteMapping("/{id}")
	   @PreAuthorize("hasRole('ADMIN')")
	    public void deleteAuthor(@PathVariable Long id) {
		   authorService.deleteAuthor(id);
	    }
	   
	   @PatchMapping("/{id}")
		  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR')")
	      public void updateAuthor(@PathVariable Long id,String nombre,String email, String bio) {
		   authorService.updateAuthor(id,nombre,email,bio);
	   }
}
