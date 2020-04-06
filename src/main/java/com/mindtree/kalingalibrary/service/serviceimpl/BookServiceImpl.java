package com.mindtree.kalingalibrary.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingalibrary.entity.Book;
import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;
import com.mindtree.kalingalibrary.exception.serviceexception.custom.BookAlreadyExists;
import com.mindtree.kalingalibrary.exception.serviceexception.custom.BookIdNotPresentException;
import com.mindtree.kalingalibrary.exception.serviceexception.custom.LibraryNotExistsException;
import com.mindtree.kalingalibrary.repository.BookRepository;
import com.mindtree.kalingalibrary.repository.LibraryRepository;
import com.mindtree.kalingalibrary.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private LibraryRepository libraryrepository;
	@Autowired
	private BookRepository bookrepository;

	@Override
	public List<Book> listAllBooks() {

		return bookrepository.findAll();
	}

	@Override
	public Book updateBook(Book book,long id) throws KalingaLibraryServiceApplicationException {

		Book existingBook = bookrepository.findById(book.getId()).orElse(null);
		existingBook.setBookName(book.getBookName());
		return bookrepository.save(existingBook);

	}

	@Override
	public Book getAll(Book book, long id) throws KalingaLibraryServiceApplicationException {
		Library library = libraryrepository.findById(id).orElse(null);
		if (library != null) {
			book.setLibrary(library);
			return bookrepository.save(book);

		} else {
			throw new LibraryNotExistsException("Library Not Exists");
		}

	}

	@Override
	public List<Book> deleteBook(long id) {
		Library library = libraryrepository.findById(id).get();
		List<Book> book = library.getBooks();
		return book;
	}

	@Override
	public void deleteBookById(long id) {
		bookrepository.deleteById(id);

	}

	@Override
	public void addBook(long libraryId, Book book) {

		Library library = libraryrepository.findById(libraryId).get();
		book.setLibrary(library);
		bookrepository.save(book);
	}

	
	@Override
	public Book updateBook(long id) {
		Library library=libraryrepository.findById(id).get();
		return bookrepository.findById(id).get();
	}

	
}
