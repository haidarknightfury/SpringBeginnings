package com.smartfox.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartfox.domain.Todo;

@Service
public class TodoService {

	public List<Todo> getTodos(){
		return Arrays.asList(new Todo("first","todo first"));
	}
	
}
