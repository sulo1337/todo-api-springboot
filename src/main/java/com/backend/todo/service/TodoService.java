package com.backend.todo.service;

import java.util.List;

import com.backend.todo.todo.entity.Todo;

public interface TodoService {

	public List<Todo> findAll();
	public Todo findById(int theId);
	public void save (Todo theTodo);
	public void deleteById(int theId);
}
