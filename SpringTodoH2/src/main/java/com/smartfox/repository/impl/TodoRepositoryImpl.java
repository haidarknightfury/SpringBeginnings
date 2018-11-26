package com.smartfox.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.smartfox.model.Todo;
import com.smartfox.repository.TodoRepository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

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

    /**
     * JDBC Template operations
     */

    private static final String SELECT_TODO = "select todo_id, label, body, flag from todo";
    private static final String INSERT_TODO = "insert into todo(label, body, flag) values (?,?,?)";
    private static final String SELECT_RECENT_TODO = SELECT_TODO + "order by todo.created_date desc limit ?";

    /**
     * Return list of todos using jdbc template- only single result in row callback handler
     *
     */
    @Override
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
    @Override
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

    public Todo save(Todo todo) {
        Long id = todo.getTodoId();
        if (id == null) {
            long newTodoId = insertTodoAndReturnId(todo);
            todo.setTodoId(newTodoId);
            return todo;
        } else {
            this.jdbcTemplate.update("update todo set label=?, created_date =?, body=?, flag=? where id=?",
                    todo.getLabel(), todo.getCreatedDate(), todo.getBody(), todo.getFlag(), id);
        }

        return todo;
    }

    private long insertTodoAndReturnId(Todo todo) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName("todo");
        jdbcInsert.setGeneratedKeyName("todo_id");
        Map<String, Object> args = new HashMap<>();
        args.put("label", todo.getLabel());
        args.put("created_date", LocalDateTime.now());
        args.put("body", todo.getBody());
        args.put("flag", todo.getFlag());
        long todoId = jdbcInsert.executeAndReturnKey(args).longValue();
        return todoId;
    }

    @SuppressWarnings("unused")
    private void insertTodo(Todo todo) {
        this.jdbcTemplate.update(INSERT_TODO, todo.getLabel(), todo.getBody(), todo.getFlag());

    }

    /**
     * TodoObj Row Mapper to map todos to object
     *
     * @author hdargaye
     *
     */
    private static final class TodoRowMapper implements RowMapper<Todo> {

        @Override
        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Todo todo = new Todo();
            todo.setTodoId(rs.getLong("todo_id"));
            todo.setLabel(rs.getString("label"));
            todo.setBody(rs.getString("body"));
            todo.setFlag(rs.getString("flag"));
            return todo;
        }
    }

    /**
     * Find One from The Table
     *
     * @param id
     * @return TodoObj
     */
    public Todo findOne(long id) {
        return this.jdbcTemplate.queryForObject(SELECT_TODO + " where todo_id =?", new TodoRowMapper(), id);
    }

    /**
     * Find All
     *
     * @return all todoobj
     */
    public List<Todo> findAll() {
        return this.jdbcTemplate.query(SELECT_TODO + " order by todo_id", new TodoRowMapper());
    }

    public List<Todo> findRecent() {
        return findRecent(10);
    }

    private List<Todo> findRecent(int count) {
        return this.jdbcTemplate.query(SELECT_RECENT_TODO, new TodoRowMapper(), count);
    }

    @Override
    public Long count() {
        return this.jdbcTemplate.queryForObject("select count(todo_id) from todo", Long.class);
    }

}
