package com.memoria.fastmath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class FastMathWebController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "index.html";
	}

}
