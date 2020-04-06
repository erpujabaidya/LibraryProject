package com.mindtree.kalingalibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.kalingalibrary.entity.Library;
import com.mindtree.kalingalibrary.exception.serviceexception.KalingaLibraryServiceApplicationException;
import com.mindtree.kalingalibrary.service.BookService;
import com.mindtree.kalingalibrary.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryservice;
	@Autowired
	private BookService bookservice;
	static Library lib = null;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Library> listLibrary = libraryservice.listAllLibraries();
		model.addAttribute("listLibrary", listLibrary);
		return "homepage";

	}

	@RequestMapping("/add")
	public String showNewLibraryPage(Model model) {
		Library library = new Library();
		model.addAttribute("library", library);

		return "addlibrary";
	}

	@PostMapping("/addlibrary")
	public String addLibrary(@ModelAttribute Library library) throws KalingaLibraryServiceApplicationException {

		libraryservice.addLibrary(library);

		return "redirect:/";
	}

	@RequestMapping(value = "/deletelibrary", method = RequestMethod.GET)

	public String showDeletedLibraryPage(Model model) {
		List<Library> library = libraryservice.deleteLibrary();
		model.addAttribute("librarylist", library);
		return "delete";
	}

	@RequestMapping("/delete")
	public String deleteLibrary(@RequestParam(name = "id") long id) {
		libraryservice.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/update/{id}")
	public ModelAndView showUpdatedLibrary(@PathVariable long id) {
		ModelAndView mav = new ModelAndView("update");
		Library library = libraryservice.update(id);
		mav.addObject("library", library);
		return mav;
	}

	@RequestMapping("/details/{id}")
	public String viewDetailsPages(@PathVariable long id, Model model) {
		Library library = libraryservice.get(id);
		model.addAttribute("library", library);
		lib = libraryservice.get(id);
		return "details";

	}

	public Library library() {
		return lib;
	}

}