package com.api.book.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = this.bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no content
        }
        return new ResponseEntity<>(books, HttpStatus.OK); // Return 200 with books if found
    }

    // Get a single book by ID handler
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if book not found
        }
        return new ResponseEntity<>(book, HttpStatus.OK); // Return 200 with the book
    }

    // Create a new book handler
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book savedBook = this.bookService.addBook(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED); // Return 201 with the saved book
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Return 500 on error
        }
    }

    // Delete book handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookService.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 on successful deletion
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if book not found
        }
    }

    // Update book handler
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        Book existingBook = bookService.getBookById(bookId);
        if (existingBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if book not found
        }

        try {
            book.setId(bookId); // Ensure the ID from URL is set on the book
            Book updatedBook = this.bookService.updateBook(book, bookId);
            if (updatedBook == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if update failed
            }
            return new ResponseEntity<>(updatedBook, HttpStatus.OK); // Return 200 with the updated book
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Return 500 if error occurs
        }
    }
}
