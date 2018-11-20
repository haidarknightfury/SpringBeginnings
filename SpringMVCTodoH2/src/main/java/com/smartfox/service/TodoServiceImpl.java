package com.smartfox.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartfox.dto.TodoDTO;
import com.smartfox.dto.builder.TodoDTOBuilder;
import com.smartfox.model.Todo;
import com.smartfox.repository.TodoRepository;

@Service
public class TodoServiceImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TodoRepository todoRepository;

    @Transactional
    public void addTodo(Todo todo) {
        this.todoRepository.add(todo);
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> buildListTodos() {
        TodoDTO todo = new TodoDTOBuilder().setLabel("First Todo").setBody("Getting Started").setFlag("Not Started").setCreatedDate(LocalDateTime.now()).build();
        this.addTodo(new Todo(todo.getLabel(), todo.getCreatedDate(), todo.getBody(), todo.getFlag()));
        return this.todoRepository.listTodos().stream().map(t -> new TodoDTO(t.getLabel(), t.getCreatedDate(), t.getBody(), t.getFlag())).collect(Collectors.toList());

    }

    public void runQuery() {
        this.jdbcTemplate.query("select * from todo", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet arg0) throws SQLException {
                System.out.println(arg0);
            }
        });
    }

}
