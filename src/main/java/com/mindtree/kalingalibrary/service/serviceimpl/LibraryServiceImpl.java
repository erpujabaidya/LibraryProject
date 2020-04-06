package com.mindtree.kalingalibrary.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;
import com.mindtree.kalingalibrary.exception.serviceexception.custom.DuplicateNameException;
import com.mindtree.kalingalibrary.repository.BookRepository;
import com.mindtree.kalingalibrary.repository.LibraryRepository;
import com.mindtree.kalingalibrary.service.LibraryService;
@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryRepository libraryrepository;
	@Autowired
	private BookRepository bookrepository;
	@Override
	public List<Library> listAllLibraries() {
		
		return libraryrepository.findAll();
	}
	@Override
	public Library addLibrary(Library library ) throws KalingaLibraryServiceApplicationException {
		  if(libraryrepository.findByLibraryName(library.getLibraryName()).isPresent()) {
		   throw new DuplicateNameException("Library With Same Name Already Exists"); 
		   
		  }
		return libraryrepository.save(library);
		
	}
	@Override
	public void delete(long id) {
		
		libraryrepository.deleteById(id);
		
		
	}
	@Override
	public Library update(long id) {
		
		return libraryrepository.findById(id).get();
	}
	@Override
	public List<Library> deleteLibrary() {
		List<Library> library=libraryrepository.findAll();
		return library;
	}
	@Override
	public Library get(long id) {
		
		return libraryrepository.findById(id).get();
	}
	

}
