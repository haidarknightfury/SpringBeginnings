package com.smartfox.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartfox.dto.TodoDTO;
import com.smartfox.model.Todo;
import com.smartfox.repository.TodoRepository;

@Service
public class TodoServiceImpl {

    /**
     * JDBC template is from the Spring JDBC library
     */

    @Autowired
    TodoRepository todoRepository;

    /**
     * Operations using entity manager
     *
     * @param todoObject
     */
    @Transactional
    public void addTodo(Todo todo) {
        this.todoRepository.add(todo);
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> buildListTodos() {
        return this.todoRepository.listTodos().stream().map(t -> new TodoDTO(t.getLabel(), t.getCreatedDate(), t.getBody(), t.getFlag())).collect(Collectors.toList());
    }

    public List<Todo> runQuery() {
        return this.todoRepository.runQuery();
    }

    public List<Todo> runQueryMoreResults() {
        return this.todoRepository.runQueryMoreResults();
    }

    public Long countResults() {
        return this.todoRepository.count();
    }

}
