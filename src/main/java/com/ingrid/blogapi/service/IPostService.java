package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;

import com.ingrid.blogapi.dto.PostRequest;
import com.ingrid.blogapi.model.Author;
import com.ingrid.blogapi.model.Post;

public interface IPostService {


	 Post createPost(PostRequest request);

	    List<Post> getAllPosts();

	    Optional<Post> getPostById(Long id);

	    void deletePost(Long id);
	    
	    void updatePost(Long id,String titulo,String content,Author author);
}
