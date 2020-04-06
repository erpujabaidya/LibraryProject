package com.mindtree.kalingalibrary.dto;

import java.util.List;

import com.mindtree.kalingalibrary.entity.Book;

public class LibraryDTO {

private long id;
List<Book> books;
public LibraryDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public LibraryDTO(long id, List<Book> books) {
	super();
	this.id = id;
	this.books = books;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public List<Book> getBooks() {
	return books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}


}
