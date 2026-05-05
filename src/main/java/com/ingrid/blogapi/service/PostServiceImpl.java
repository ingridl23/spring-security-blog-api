package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ingrid.blogapi.dto.PostRequest;
import com.ingrid.blogapi.model.Author;
import com.ingrid.blogapi.model.Post;
import com.ingrid.blogapi.repository.AuthorRepository;
import com.ingrid.blogapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

	private final PostRepository postRepository;
	private final AuthorRepository authorRepository;
	
	@Override
	public Post createPost(PostRequest request) {
		Post post = Post.builder()
                .titulo(request.getTitulo())
                .build();
   
        return postRepository.save(post);
	}

	
	
	@Override
	public List<Post> getAllPosts() {
		return  postRepository.findAll();
	
}

	@Override
	public Optional<Post> getPostById(Long id) {
		return  postRepository.findById(id);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
		
	}

	@Override
	public void updatePost(Long id, String titulo,String content,Author author) {
		 Post post = postRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("Post not found"));

			    post.setTitulo(titulo);
                post.setContent(content);
                post.setAutor(author);
			    postRepository.save(post);
		
	}

}
