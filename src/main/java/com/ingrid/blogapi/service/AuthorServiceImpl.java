package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ingrid.blogapi.dto.AuthorRequest;
import com.ingrid.blogapi.model.Author;
import com.ingrid.blogapi.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService{
	private final AuthorRepository authorRepository ;
	@Override
	public Author createAuthor(AuthorRequest request) {
		Author author = Author.builder()
	                .name(request.getNombre())
	                .build();
	   
	        return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Long id) {
		return authorRepository.findById(id);
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}

	@Override
	public void updateAuthor(Long id, String nombre,String email, String bio) {
	
		 Author author = authorRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("Autor not found"));

			    author.setName(nombre);
                author.setEmail(email);
                author.setBio(bio);
			    authorRepository.save(author);
	}

}
