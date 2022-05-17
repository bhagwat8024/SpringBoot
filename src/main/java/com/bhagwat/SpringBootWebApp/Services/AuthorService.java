package com.bhagwat.SpringBootWebApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagwat.SpringBootWebApp.Model.Author;
import com.bhagwat.SpringBootWebApp.Repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}
	public Author getById(long id) {
		return authorRepository.getById(id);
	}
}
