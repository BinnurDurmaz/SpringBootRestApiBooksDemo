package com.binnur.springbootrestapiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binnur.springbootrestapiproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
