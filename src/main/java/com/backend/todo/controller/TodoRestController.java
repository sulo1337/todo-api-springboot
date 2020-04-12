package com.backend.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.todo.service.TodoService;
import com.backend.todo.todo.entity.Todo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TodoRestController {

	private TodoService todoService;
	
	@Autowired
	public TodoRestController(TodoService theTodoService) {
		todoService = theTodoService;
	}
	
	@GetMapping("/todos")
	public List<Todo> findAll(){
		return todoService.findAll();
	}
	
	@GetMapping("/todos/{todoId}")
	public Todo getTodos(@PathVariable int todoId) {
		Todo theTodo = todoService.findById(todoId);
		
		if(theTodo == null) {
			throw new RuntimeException("Todo id not found - "+todoId);
		}
		
		return theTodo;
	}
	
	@PostMapping("/todos")
	public Todo addTodo(@RequestBody Todo theTodo) {
		theTodo.setId(0);
		todoService.save(theTodo);
		return theTodo;
	}
	
	@RequestMapping(value="/todos", produces="application/json", method=RequestMethod.PUT)
	public Todo updateEmployee(@RequestBody Todo theTodo) {
		todoService.save(theTodo);
		return theTodo;
	}
	
	@DeleteMapping("/todos/{todoId}")
	public String deleteEmployee(@PathVariable int todoId) {
		Todo tempTodo = todoService.findById(todoId);
		
		if(tempTodo == null) {
			return "Todo id not found - " + todoId;
		}
		
		todoService.deleteById(todoId);
		
		return "Deleted todo id - "+todoId;
		
	}
}
