package com.company.simplelibrary.service;

import com.company.simplelibrary.model.User;
import com.company.simplelibrary.repository.UserRepository;
import com.company.simplelibrary.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addReader(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeReader(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> index() {
        return userRepository.findAll();
    }
}
