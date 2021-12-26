package com.company.simplelibrary.controller;

import com.company.simplelibrary.model.User;
import com.company.simplelibrary.service.dao.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.index();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    public void addReader(@RequestBody @Valid User user) {
        userService.addReader(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteBook(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.removeReader(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
