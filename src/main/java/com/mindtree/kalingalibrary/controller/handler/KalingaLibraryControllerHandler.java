package com.mindtree.kalingalibrary.controller.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.kalingalibrary.exception.KalingaLibraryApplicationException;
@ControllerAdvice
public class KalingaLibraryControllerHandler {

	
		
		@org.springframework.web.bind.annotation.ExceptionHandler
		
		public ModelAndView exceptionHandler(HttpServletRequest req,KalingaLibraryApplicationException e) {
			ModelAndView mav=new ModelAndView();
			mav.addObject("status",HttpStatus.NOT_FOUND.value());
			mav.addObject("ErrorMessage",e.getMessage());
		 mav.addObject("TimeStamp",new Date());
			
			return mav;
			
		
	}

}
