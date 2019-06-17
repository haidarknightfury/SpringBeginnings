package com.smartfox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfox.model.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

    public List<UserAuthority> findByUsername(String username);
}
