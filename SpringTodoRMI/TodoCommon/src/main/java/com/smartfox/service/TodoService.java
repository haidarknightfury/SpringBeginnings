package com.smartfox.service;

import com.smartfox.model.Todo;

public interface TodoService {

    public Todo create(String name, String body);

    public Todo find(String name);
}
