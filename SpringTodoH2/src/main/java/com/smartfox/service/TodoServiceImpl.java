package com.smartfox.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartfox.dto.TodoDTO;
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
        return this.todoRepository.listTodos().stream().map(t -> new TodoDTO(t.getLabel(), t.getCreatedDate(), t.getBody(), t.getFlag())).collect(Collectors.toList());
    }

    /**
     * Return list of todos using jdbc template- only single result in row callback handler
     *
     */
    public List<Todo> runQuery() {
        List<Todo> todos = new ArrayList<>();
        this.jdbcTemplate.query("SELECT * FROM todo", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Todo todo = new Todo();
                todo.setTodoId(rs.getLong("todo_id"));
                todo.setLabel(rs.getString("label"));
                todo.setBody(rs.getString("body"));
                todo.setFlag(rs.getString("flag"));
                todos.add(todo);
            }
        });
        return todos;
    }

    /**
     * Retrieve List of results
     *
     */
    public List<Todo> runQueryMoreResults() {
        return this.jdbcTemplate.query("SELECT * FROM todo", new ResultSetExtractor<List<Todo>>() {
            @Override
            public List<Todo> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Todo> todos = new ArrayList<>();
                while (rs.next()) {
                    Todo todo = new Todo();
                    todo.setTodoId(rs.getLong("todo_id"));
                    todo.setLabel(rs.getString("label"));
                    todo.setBody(rs.getString("body"));
                    todo.setFlag(rs.getString("flag"));
                    todos.add(todo);
                }
                return todos;
            }

        });
    }

}
