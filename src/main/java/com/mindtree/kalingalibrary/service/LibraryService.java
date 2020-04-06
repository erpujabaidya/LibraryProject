package com.mindtree.kalingalibrary.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.kalingalibrary.entity.Book;
import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;

public interface LibraryService {

	List<Library> listAllLibraries();

	Library addLibrary(Library library) throws KalingaLibraryServiceApplicationException;

	void delete(long id);

	Library update(long id);

	List<Library> deleteLibrary();

	Library get(long id);

	

}
