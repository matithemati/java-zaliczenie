package com.matithemati.zaliczenie.service.implementations;

import com.matithemati.zaliczenie.exception.BookNotFoundException;
import com.matithemati.zaliczenie.models.BookDbModel;
import com.matithemati.zaliczenie.models.BookDto;
import com.matithemati.zaliczenie.models.Book;
import com.matithemati.zaliczenie.repository.BookRepository;
import com.matithemati.zaliczenie.service.MainService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Profile("db")
public class MainServiceDbImplementation implements MainService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Override
    public List<Book> getAllBooks() {
        List<BookDbModel> books = bookRepository.findAll();
        return books
                .stream()
                .map(book -> modelMapper.map(book, Book.class))
                .toList();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .map(book -> modelMapper.map(book, Book.class))
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book createBook(BookDto book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null");
        }

        return modelMapper.map(bookRepository.save(modelMapper.map(book, BookDbModel.class)), Book.class);
    }

    @Override
    public Book updateBook(String id, BookDto book) {
        BookDbModel existingBook = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());

        return modelMapper.map(bookRepository.save(existingBook), Book.class);
    }

    @Override
    public void deleteBook(String id) {
        Book book = getBookById(id);
        bookRepository.deleteById(book.getId());
    }
}
