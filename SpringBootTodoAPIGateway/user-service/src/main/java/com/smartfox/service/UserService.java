package com.smartfox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.model.User;
import com.smartfox.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findUser(String userName) {
        return this.userRepository.findAll().stream().filter(user -> user.getUsername().equalsIgnoreCase(userName)).findAny().orElseThrow(() -> new IllegalArgumentException(userName + "not found"));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
