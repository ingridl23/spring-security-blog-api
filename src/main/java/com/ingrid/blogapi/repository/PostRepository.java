package com.ingrid.blogapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingrid.blogapi.model.Post;


public interface PostRepository extends JpaRepository<Post, Long>{
	Optional<Post> findByTitulo(String titulo);
}
