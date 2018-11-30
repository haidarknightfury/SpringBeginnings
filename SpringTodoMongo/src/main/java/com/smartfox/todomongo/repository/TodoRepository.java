package com.smartfox.todomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartfox.todomongo.domain.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, Integer> {

    Todo findByTitle(String title);

    // ?0 is the zeroth parameter
    @Query("{'body':'body', 'title':'?0' }")
    List<Todo> findMyTodo(String title);

    List<Todo> findByTitleLike(String title);

    List<Todo> findByTitleLikeAndBody(String title, String body);

    List<Todo> findByTitleAndBody(String title, String body);
}
