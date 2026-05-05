package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;

import com.ingrid.blogapi.dto.AuthorRequest;

import com.ingrid.blogapi.model.Author;

public interface IAuthorService {

	 Author createAuthor(AuthorRequest request);

	    List<Author> getAllAuthors();

	    Optional<Author> getAuthorById(Long id);

	    void deleteAuthor(Long id);
	    
	    void updateAuthor(Long id,String nombre,String email,String bio);
}
