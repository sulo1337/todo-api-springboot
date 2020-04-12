package com.backend.todo.todo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="todo_data")
public class Todo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="title")
		private String title;
		
		@Column(name="completed")
		private boolean completed;
		
		@Column(name="deadline")
		private Date deadline;
		
		@Column(name="added")
		private Date added;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isCompleted() {
			return completed;
		}

		public void setCompleted(boolean completed) {
			this.completed = completed;
		}



		public Date getTimeToComplete() {
			return deadline;
		}

		public void setTimeToComplete(Date timeToComplete) {
			this.deadline = timeToComplete;
		}

		public Date getAdded() {
			return added;
		}

		public void setAdded(Date added) {
			this.added = added;
		}

		@Override
		public String toString() {
			return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", timeToComplete="
					+ deadline + ", added=" + added + "]";
		}

		

		
}
