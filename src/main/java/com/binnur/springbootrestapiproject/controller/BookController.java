package com.binnur.springbootrestapiproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binnur.springbootrestapiproject.dao.BookDAO;
import com.binnur.springbootrestapiproject.model.Book;


@RestController
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	BookDAO bookDAO;
	
	/* to save an book*/
	@PostMapping("/books")
	public Book createEmployee(@Valid @RequestBody Book emp) {
		return bookDAO.save(emp);
	}
	
	/*get all books*/
	@GetMapping("/books")
	public List<Book> getAllEmployees(){
		return bookDAO.findAll();
	}
	
	/*get book by bookId*/
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getEmployeeById(@PathVariable(value="id") Long bookId){
		
		Book book=bookDAO.findOne(bookId);
		
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(book);
		
	}
	

	@GetMapping("/books/isbn/{isbn}")
	public ResponseEntity<Book> getEmployeeByIsbn(@PathVariable(value="isbn") Long isbn){
 
		List<Book> bookList=bookDAO.findOneISBN();
		Book b=new Book();
		for(Book item:bookList){
			if(item.getISBN().equals(isbn)) {
				b=item;
				break;
			}
		}
		/*if(book==null) {
			return ResponseEntity.notFound().build();
		}*/
		return ResponseEntity.ok().body(b);
		
	}
	
	
	/*update an book by bookId*/
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateEmployee(@PathVariable(value="id") Long bookId,@Valid @RequestBody Book bookDetails){
		
		Book book=bookDAO.findOne(bookId);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		
		book.setName(bookDetails.getName());
		book.setTitle(bookDetails.getTitle());
		book.setDescription(bookDetails.getDescription());
		book.setAuthor(bookDetails.getAuthor());
		book.setNumberOfPages(bookDetails.getNumberOfPages());
		book.setPublisher(bookDetails.getPublisher());
		book.setISBN(bookDetails.getISBN());
		book.setPublishingYear(bookDetails.getPublishingYear());
		book.setType(bookDetails.getType());
		
		
		
		Book updateBook=bookDAO.save(book);
		return ResponseEntity.ok().body(updateBook);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteEmployee(@PathVariable(value="id") Long bookId){
		
		Book book=bookDAO.findOne(bookId);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		bookDAO.delete(book);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
