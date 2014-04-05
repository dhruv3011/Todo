package com.example.todo;

public class Todo {

	private String name;
	private String note;

	public Todo() {
	}

	public Todo(String name, String note) {
		this.name = name;
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
