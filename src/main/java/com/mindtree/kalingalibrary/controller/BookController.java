package com.mindtree.kalingalibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.kalingalibrary.entity.Book;
import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.KalingaLibraryApplicationException;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;
import com.mindtree.kalingalibrary.service.BookService;
import com.mindtree.kalingalibrary.service.LibraryService;

@Controller
public class BookController {
	static Library library;

	@Autowired
	private LibraryService libraryservice;
	@Autowired
	private BookService bookservice;
	private long libraryId;
	private long dlibraryId;

	@RequestMapping("/details")
	public String viewDetailsHomePage(Model model) {
		List<Book> listBooks = bookservice.listAllBooks();
		model.addAttribute("listBooks", listBooks);
		return "details";

	}

	@RequestMapping("/addbook/{id}")
	public String showNewBookPage(Model model, @PathVariable long id) {

		Book book = new Book();
		libraryId = id;
		System.out.println(id);
		model.addAttribute("book", book);

		return "addbook";
	}

	@PostMapping("/success")
	public String addBook(@ModelAttribute("book") Book book) {
		// library=new LibraryController().library();
		bookservice.addBook(libraryId, book);
		return "redirect:/details/" + libraryId;

	}

	@RequestMapping("/updatebook/{id}")
	public String showUpdatedBookPage(Model model, @PathVariable long id) {
		Book book = new Book();
		libraryId = id;
		model.addAttribute("book", book);

		return "updatebook";
	}

//	@PostMapping("/update")
//	public String updateBook(@ModelAttribute Book book, @PathVariable long id)
//			throws KalingaLibraryServiceApplicationException {
//		bookservice.updateBook(book, id);
//		return "redirect:/details";
//
//	}

	@RequestMapping("/update")
	public ModelAndView showUpdatedBook(@PathVariable long id) throws KalingaLibraryApplicationException {
		ModelAndView mav = new ModelAndView("updatebook");
		Book book = bookservice.updateBook(id);
		mav.addObject("book", book);
		return mav;
	}

	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String showDeletedBookPage(Model model, @PathVariable long id) {

		List<Book> books = bookservice.deleteBook(id);
		model.addAttribute("booklist", books);

		return "deletebook";

	}

	@RequestMapping("/deletebooks")
	public String deleteBook(@RequestParam(name = "id") long id) {

		bookservice.deleteBookById(id);
		libraryId = id;
		return "redirect:/";

	}

}
