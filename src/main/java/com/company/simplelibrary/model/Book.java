package com.company.simplelibrary.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "author", nullable = false, columnDefinition = "TEXT")
    private String author;
    @Column(name = "publisher", nullable = false, columnDefinition = "TEXT")
    private String publisher;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Book(String title, String author, String publisher, User user) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher) && Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publisher, user);
    }
}
