package com.company.simplelibrary.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "reader")
public class User {
    @Id
    @SequenceGenerator(name = "reader_sequence", sequenceName = "reader_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader_sequence")
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "surname", nullable = false, columnDefinition = "TEXT")
    private String surname;
    @OneToMany(mappedBy = "user")
    private List<Book> bookList;

    public User() {}

    public User(String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(bookList, user.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, bookList);
    }
}
