package com.bhagwat.SpringBootWebApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagwat.SpringBootWebApp.Model.Book;
import com.bhagwat.SpringBootWebApp.Repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book getBookById(long id) {
		return bookRepository.getById(id);
	}
	
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}
	
	public boolean isExist(Long bookCode) {
		Optional<Book> book = bookRepository.findById(bookCode);
		if(book.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
		
	}
	
}
