package com.smartfox.todomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartfox.todomongo.domain.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, Integer> {

    Todo findByTitle(String title);
}
