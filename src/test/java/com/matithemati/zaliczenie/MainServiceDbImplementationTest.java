package com.matithemati.zaliczenie;

import com.matithemati.zaliczenie.models.Book;
import com.matithemati.zaliczenie.models.BookDbModel;
import com.matithemati.zaliczenie.models.BookDto;
import com.matithemati.zaliczenie.repository.BookRepository;
import com.matithemati.zaliczenie.service.implementations.MainServiceDbImplementation;
import com.matithemati.zaliczenie.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainServiceDbImplementationTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MainServiceDbImplementation mainService;

    @Test
    void getAllBooks_ShouldReturnAllBooks() {

        BookDbModel bookDbModel1 = BookDbModel.builder().id("1").title("Title 1").author("Author 1").build();
        BookDbModel bookDbModel2 = BookDbModel.builder().id("2").title("Title 2").author("Author 2").build();

        List<BookDbModel> bookDbModels = Arrays.asList(bookDbModel1, bookDbModel2);
        when(bookRepository.findAll()).thenReturn(bookDbModels);

        List<Book> result = mainService.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    void getBookById_NonExistingId_ShouldThrowException() {
        when(bookRepository.findById(String.valueOf(1))).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> mainService.getBookById(String.valueOf(1)));
    }

    @Test
    void createBook_ValidBookDto_ShouldCreateBook() {
        BookDbModel bookDbModel = BookDbModel.builder().id("1").title("Title").author("Author").build();
        when(bookRepository.save(any(BookDbModel.class))).thenReturn(bookDbModel);

        BookDbModel result = bookRepository.save(bookDbModel);

        assertNotNull(result);
        assertEquals("Title", result.getTitle());
        assertEquals("Author", result.getAuthor());
    }

    @Test
    void createBook_NullBookDto_ShouldThrowException() {
        BookDto nullBookDto = null;
        assertThrows(NullPointerException.class, () -> mainService.createBook(nullBookDto));
    }
}
