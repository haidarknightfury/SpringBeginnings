package com.smartfox.todomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartfox.todomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
