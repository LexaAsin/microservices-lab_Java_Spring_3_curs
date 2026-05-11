package com.dolsoft.authorservice.controller;

import com.dolsoft.authorservice.model.Author;
import com.dolsoft.authorservice.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        log.info("GET author by id: {}", id);
        Author author = authorService.getAuthor(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        author.add(linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel());
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        log.info("GET all authors called");
        return authorService.getAllAuthors();
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        log.info("POST create author: {}", author.getFullName());
        Author created = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        log.info("PUT update author id: {}", id);
        author.setId(id);
        Author updated = authorService.updateAuthor(author);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        log.info("DELETE author id: {}", id);
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}