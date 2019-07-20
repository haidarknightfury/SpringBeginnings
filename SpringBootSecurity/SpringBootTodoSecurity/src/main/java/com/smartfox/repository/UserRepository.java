package com.smartfox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfox.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
