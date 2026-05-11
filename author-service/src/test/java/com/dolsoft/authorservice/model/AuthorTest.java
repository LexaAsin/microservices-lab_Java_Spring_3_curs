package com.dolsoft.authorservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void testAuthorEntity() {
        Author author = new Author();
        author.setId(1L);
        author.setFullName("John Doe");
        author.setPhone("+7-999-123-45-67");
        author.setEmail("john@example.com");
        author.setRating(5);

        assertEquals(1L, author.getId());
        assertEquals("John Doe", author.getFullName());
        assertEquals("+7-999-123-45-67", author.getPhone());
        assertEquals("john@example.com", author.getEmail());
        assertEquals(5, author.getRating());
    }
}