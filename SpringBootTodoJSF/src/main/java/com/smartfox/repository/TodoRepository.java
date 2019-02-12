package com.smartfox.repository;

import com.smartfox.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdargaye on 12/02/2019.
 */
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
