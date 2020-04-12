package com.backend.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.todo.dao.TodoDAO;
import com.backend.todo.todo.entity.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	private TodoDAO todoDAO;
	
	public TodoServiceImpl(TodoDAO theTodoDAO) {
		todoDAO = theTodoDAO;
	}
	
	@Override
	@Transactional
	public List<Todo> findAll() {
		return todoDAO.findAll();
	}

	@Override
	@Transactional
	public Todo findById(int theId) {
		return todoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Todo theTodo) {
		todoDAO.save(theTodo);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		todoDAO.deleteById(theId);
	}

}
