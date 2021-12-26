package com.company.simplelibrary.service.dao;

import com.company.simplelibrary.model.User;

import java.util.List;

public interface UserService {
    void addReader(User user);
    void removeReader(int id);
    User findById(int id);
    List<User> index();
}
