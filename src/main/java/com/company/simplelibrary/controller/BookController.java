package com.company.simplelibrary.controller;

import com.company.simplelibrary.model.Book;
import com.company.simplelibrary.model.User;
import com.company.simplelibrary.service.dao.BookService;
import com.company.simplelibrary.service.dao.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    // localhost:8004/library/books
    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.index();
    }

    // localhost:8004/library/books/{bookId}
    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }


    @PostMapping("/add")
    public void addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/take/{bookId}/{userId}")
    public ResponseEntity<Book> takeBook(@Valid @PathVariable("bookId") Integer bookId,
                                         @Valid @PathVariable("userId") Integer userId) {
        Book book = bookService.findById(bookId);
        User user = userService.findById(userId);
        if (book.getUser() == null) {
            book.setUser(user);
            bookService.addBook(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/return/{bookId}/{userId}")
    public ResponseEntity<Book> returnBook(@PathVariable("bookId") Integer bookId,
                                           @PathVariable("userId") Integer userId) {
        Book book = bookService.findById(bookId);
        if(book.getUser().getId() == userId){
            book.setUser(null);
            bookService.addBook(book);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}