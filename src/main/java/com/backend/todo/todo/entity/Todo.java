package com.backend.todo.todo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="todoTable")
public class Todo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="title")
		private String title;
		
		@Column(name="description")
		private String description;
		
		@Column(name="completed")
		private boolean completed;
		
		@Column(name="deadline")
		@Temporal(value = TemporalType.TIMESTAMP)
		@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date deadline;
		
		@Column(name="added")
		@Temporal(value = TemporalType.TIMESTAMP)
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public boolean isCompleted() {
			return completed;
		}

		public void setCompleted(boolean completed) {
			this.completed = completed;
		}

		public Date getDeadline() {
			return deadline;
		}

		public void setDeadline(Date deadline) {
			this.deadline = deadline;
		}

		public Date getAdded() {
			return added;
		}

		public void setAdded(Date added) {
			this.added = added;
		}

		@Override
		public String toString() {
			return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
					+ ", deadline=" + deadline + ", added=" + added + "]";
		}
		
		

		

		
}
