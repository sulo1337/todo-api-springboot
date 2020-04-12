package com.backend.todo.dao;

import java.util.List;

import com.backend.todo.todo.entity.Todo;

public interface TodoDAO {

		public List<Todo> findAll();
		public Todo findById(int theId);
		public void save(Todo theTodo);
		public void deleteById(int theId);
}
