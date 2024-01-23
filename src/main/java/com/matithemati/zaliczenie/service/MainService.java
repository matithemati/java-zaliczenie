package com.matithemati.zaliczenie.service;

import com.matithemati.zaliczenie.models.BookDto;
import com.matithemati.zaliczenie.models.Book;

import java.util.List;

public interface MainService {
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book createBook(BookDto book);
    Book updateBook(String id, BookDto book);
    void deleteBook(String id);
}
