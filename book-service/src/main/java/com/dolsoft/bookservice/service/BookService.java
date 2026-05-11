package com.dolsoft.bookservice.service;

import com.dolsoft.bookservice.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    public Book getBook(String id) {
        Book book = new Book();
        book.setId(new Random().nextLong(1000));
        book.setTitle("Spring Boot in Action");
        book.setCoverType("Hardcover");
        book.setPublisher("Manning");
        book.setYear(2022);
        book.setGenre("Programming");
        return book;
    }

    public List<Book> getAllBooks() {
        return Arrays.asList(
            new Book(1L, "Spring Boot in Action", "Hardcover", "Manning", 2022, "Programming"),
            new Book(2L, "Clean Code", "Paperback", "Prentice Hall", 2008, "Programming")
        );
    }

    public Book createBook(Book book) {
        log.info("Creating book: {}", book.getTitle());
        return book;  // сохраняем и возвращаем
    }

    public Book updateBook(Book book) {
        log.info("Updating book: {}", book.getTitle());
        return book;
    }

    public String deleteBook(String id) {
        return "Book with id " + id + " deleted";
    }
}