package com.memoria.fastmath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FastMathWebController {
		
	@GetMapping("")
	public ModelAndView math() {
		return new ModelAndView("index");
	}
	
}
