package com.suzasob.bita.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suzasob.bita.employee.model.User;
import com.suzasob.bita.employee.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User users) {
        return userRepository.save(users);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User user) {
        User extingUser = userRepository.findById(user.getId()).get();
        extingUser.setFirstName(user.getFirstName());
        extingUser.setLastName(user.getLastName());
        extingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(extingUser);
        return updateUser;

    }

}
