package com.smartfox.SpringBootH2JPA.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id")
    private Long todoId;

    @Column(name = "label")
    private String label;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "body")
    private String body;

    @Column(name = "flag")
    private String flag;

    public Todo() {

    }

    public Todo(String label, LocalDateTime createdDate, String body, String flag) {
        super();
        this.label = label;
        this.createdDate = createdDate;
        this.body = body;
        this.flag = flag;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getTodoId() {
        return this.todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    @Override
    public String toString() {
        return "TodoDTO [label=" + this.label + ", createdDate=" + this.createdDate + ", body=" + this.body + ", flag=" + this.flag + "]";
    }

}
