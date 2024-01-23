package com.matithemati.zaliczenie.service.implementations;

import com.matithemati.zaliczenie.exception.BookNotFoundException;
import com.matithemati.zaliczenie.models.BookDto;
import com.matithemati.zaliczenie.models.Book;
import com.matithemati.zaliczenie.service.MainService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Profile("dao")
public class MainServiceDaoImplementation implements MainService {

    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book createBook(BookDto book) {
        Book newBook = Book.builder()
                .id(UUID.randomUUID().toString())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();

        books.add(newBook);

        return newBook;
    }

    @Override
    public Book updateBook(String id, BookDto book) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());

        return existingBook;
    }

    @Override
    public void deleteBook(String id) {
        books.remove(getBookById(id));
    }
}
