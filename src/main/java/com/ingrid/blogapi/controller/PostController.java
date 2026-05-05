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

import com.ingrid.blogapi.dto.PostRequest;
import com.ingrid.blogapi.model.Author;
import com.ingrid.blogapi.model.Post;
import com.ingrid.blogapi.service.PostServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostServiceImpl  postService;
	
	  @PostMapping
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR')")
	    public Post createPost(@RequestBody PostRequest request) {
	        return postService.createPost(request);
	    }

	  @GetMapping
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR','USER')")
	    public List<Post> getAllPosts() {
	        return postService.getAllPosts();
	    }
	  
	  @GetMapping("/{id}")
	  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR','USER')")
	    public Optional<Post> getPostById(@PathVariable Long id) {
	        return postService.getPostById(id);
	    }
	    
	   @DeleteMapping("/{id}")
	   @PreAuthorize("hasRole('ADMIN')")
	    public void deletePost(@PathVariable Long id) {
		   postService.deletePost(id);
	    }
	   
	   @PatchMapping("/{id}")
		  @PreAuthorize("hasAnyRole('ADMIN', 'AUTHOR')")
	      public void updatePost(@PathVariable Long id,String titulo ,String content,Author auth) {
		   postService.updatePost(id,titulo,content,auth);
	   }
	
}
