package com.dolsoft.bookservice.controller;

import com.dolsoft.bookservice.model.Book;
import com.dolsoft.bookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        log.info("GET book by id: {}", id);
        Book book = bookService.getBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        book.add(linkTo(methodOn(BookController.class).getBook(id)).withSelfRel());
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        log.info("GET all books called");
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("POST create book: {}", book.getTitle());
        Book created = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        log.info("PUT update book id: {}", id);
        book.setId(Long.parseLong(id));
        Book updated = bookService.updateBook(book);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        log.info("DELETE book id: {}", id);
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}