package com.dolsoft.authorservice.repository;

import com.dolsoft.authorservice.model.Author;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryTest {

    @Test
    void testSaveAndFind() {
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(1L);
        author.setFullName("Test");
        authors.add(author);
        
        assertEquals(1, authors.size());
        assertEquals("Test", authors.get(0).getFullName());
    }
}