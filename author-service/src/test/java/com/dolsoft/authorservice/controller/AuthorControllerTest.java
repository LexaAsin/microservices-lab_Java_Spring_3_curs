package com.dolsoft.authorservice.controller;

import com.dolsoft.authorservice.model.Author;
import com.dolsoft.authorservice.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @Test
    void testGetAllAuthors() {
        Author a1 = new Author(1L, "John Doe", "+7-999-123-45-67", "john@example.com", 5);
        Author a2 = new Author(2L, "Jane Smith", "+7-999-987-65-43", "jane@example.com", 4);
        when(authorService.getAllAuthors()).thenReturn(Arrays.asList(a1, a2));

        List<Author> result = authorController.getAllAuthors();
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getFullName());
    }
}