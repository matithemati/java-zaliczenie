package com.matithemati.zaliczenie.controller;

import com.matithemati.zaliczenie.exception.PropertyNotFoundException;
import com.matithemati.zaliczenie.models.Book;
import com.matithemati.zaliczenie.models.BookDto;
import com.matithemati.zaliczenie.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
@AllArgsConstructor
public class MainController {

    private Environment env;
    private MainService mainService;

    @GetMapping("/property")
    public ResponseEntity<?> getProperty(@RequestParam String name) {
        String property = env.getProperty(name);

        if (property == null) {
            throw new PropertyNotFoundException();
        }

        return ResponseEntity.ok(property);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(mainService.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(mainService.getBookById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody BookDto book) {
        return ResponseEntity.ok(mainService.createBook(book));
    }

    @PatchMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody BookDto book) {
        return ResponseEntity.ok(mainService.updateBook(id, book));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        mainService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
