package com.company.simplelibrary.service.dao;

import com.company.simplelibrary.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void removeBook(int id);
    Book findById(int id);
    List<Book> index();
}
