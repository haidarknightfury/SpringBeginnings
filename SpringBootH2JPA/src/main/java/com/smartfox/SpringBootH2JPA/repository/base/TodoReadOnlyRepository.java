package com.smartfox.SpringBootH2JPA.repository.base;

import com.smartfox.SpringBootH2JPA.model.Todo;

public interface TodoReadOnlyRepository extends ReadOnlyRepository<Todo, Long> {
	
	Todo findByLabel(String label);
}
