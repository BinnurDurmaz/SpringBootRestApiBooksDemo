package com.binnur.springbootrestapiproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binnur.springbootrestapiproject.model.Book;
import com.binnur.springbootrestapiproject.repository.BookRepository;

@Service
public class BookDAO {
	
	private Book bookObject=new Book();
	@Autowired
	BookRepository bookRepository;
	
	// TO SAVE AN BOOK //
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	// SEARCH ALL BOOKS //
	
	public List<Book> findAll()
	{
		return bookRepository.findAll();
	}
	
	// GET AN BOOK BY ID //
	
	public Book findOne(Long bookId)
	{
		return bookRepository.findOne(bookId);
	}
	
	public List<Book> findOneISBN()
	{
		return bookRepository.findAll();
	}
	
	// DELETE AN BOOK BY ID  //
	
	public void delete(Book book)
	{
		bookRepository.delete(book);
	}


}
