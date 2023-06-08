package com.suzasob.bita.employee.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suzasob.bita.employee.model.User;
import com.suzasob.bita.employee.repository.UserRepository;
import com.suzasob.bita.employee.services.UserServices;

@RestController
@RequestMapping("api/users")
public class UserController {
    /*
     * @Autowired
     * private UserRepository userRepository;
     */
    @Autowired
    private UserServices userServices;

    // create post
    @PostMapping("/adduser")
    /*
     * public void addUser(@RequestBody User users) {
     * userRepository.save(users);
     * }
     */

    public ResponseEntity<User> createUser(@RequestBody User users) {
        User savedUser = userServices.createUser(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/userlist")
    public ResponseEntity<List<User>> getAllusers() {
        List<User> users = userServices.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/userbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userServices.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userServices.deleteUser(userId);
        return new ResponseEntity<String>("User Successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, User user) {
        user.setId(userId);
        User userupdate = userServices.updateUser(user);
        return new ResponseEntity<>(userupdate, HttpStatus.OK);
    }

}
