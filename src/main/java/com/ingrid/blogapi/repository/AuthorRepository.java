package com.ingrid.blogapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingrid.blogapi.model.Author;

public interface AuthorRepository  extends JpaRepository<Author, Long>{
	 Optional<Author> findByName(String name);
}
