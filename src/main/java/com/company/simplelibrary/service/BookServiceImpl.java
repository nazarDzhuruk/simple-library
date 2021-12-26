package com.company.simplelibrary.service;

import com.company.simplelibrary.model.Book;
import com.company.simplelibrary.model.User;
import com.company.simplelibrary.repository.BookRepository;
import com.company.simplelibrary.service.dao.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> index() {
        return bookRepository.findAll();
    }
}
