package com.smartfox.todoactivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfox.todoactivi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

}
