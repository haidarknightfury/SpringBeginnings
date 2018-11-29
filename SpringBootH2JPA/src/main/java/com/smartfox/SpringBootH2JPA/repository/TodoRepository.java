package com.smartfox.SpringBootH2JPA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smartfox.SpringBootH2JPA.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long> , QueryDslPredicateExecutor<Todo>{

}
