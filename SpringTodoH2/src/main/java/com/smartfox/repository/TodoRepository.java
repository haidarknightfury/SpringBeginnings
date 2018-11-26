package com.smartfox.repository;

import java.util.List;

import com.smartfox.model.Todo;

public interface TodoRepository {
    void add(Todo todo);

    List<Todo> listTodos();

    List<Todo> runQuery();

    List<Todo> runQueryMoreResults();
}
