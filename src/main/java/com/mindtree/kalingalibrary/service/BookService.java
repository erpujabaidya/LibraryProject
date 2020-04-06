package com.mindtree.kalingalibrary.service;

import java.util.List;

import com.mindtree.kalingalibrary.entity.Book;
import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;

public interface BookService {

	List<Book> listAllBooks();

	void addBook(long libraryId, Book book);

	Book updateBook(long id) throws KalingaLibraryServiceApplicationException;

	Book getAll(Book book, long id) throws KalingaLibraryServiceApplicationException;

	void deleteBookById(long id);

	List<Book> deleteBook(long id);

Book updateBook(Book book, long id) throws KalingaLibraryServiceApplicationException;

}
