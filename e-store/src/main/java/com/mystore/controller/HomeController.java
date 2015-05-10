package com.mystore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( value = "/" )
public class HomeController {

	public final String INDEX_VIEW = "index";
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public ModelAndView index() {
		
		return new ModelAndView( INDEX_VIEW );
	}
}
