package com.backend.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.todo.todo.entity.Todo;

@Repository
public class TodoDAOHibernate implements TodoDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public TodoDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Todo> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		//Todo because my Entity name is Todo
		Query<Todo> theQuery = currentSession.createQuery("from Todo", Todo.class);
		List<Todo> todos = theQuery.getResultList();
		return todos;
	}

	@Override
	public Todo findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Todo theTodo = currentSession.get(Todo.class, theId);
		return theTodo;
	}

	@Override
	public void save(Todo theTodo) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theTodo);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Todo where id=:todoId");
		theQuery.setParameter("todoId", theId);
		theQuery.executeUpdate();
	}
	
}
