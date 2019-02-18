package com.smartfox.todoactivi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    private Date birthDate;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Person() {
        super();
    }

    public Person(String name, Date date) {
        this.name = name;
        this.birthDate = date;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
