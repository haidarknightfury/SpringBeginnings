package com.smartfox.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.smartfox.model.Todo;
import com.smartfox.repository.TodoRepository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Todo todo) {
        this.entityManager.persist(todo);
        this.entityManager.flush();// Flush is important?
    }

    @Override
    public List<Todo> listTodos() {
        CriteriaQuery<Todo> criteriaQuery = this.entityManager.getCriteriaBuilder().createQuery(Todo.class);
        Root<Todo> root = criteriaQuery.from(Todo.class);

        CriteriaQuery<Todo> all = criteriaQuery.select(root);
        TypedQuery<Todo> allQuery = this.entityManager.createQuery(all);

        return allQuery.getResultList();
    }

}
