package com.memoria.fastmath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoria.fastmath.model.Equation;
import com.memoria.fastmath.model.PostResultsBodyParams;
import com.memoria.fastmath.service.FastMathService;

@RestController
@RequestMapping("/math")
public class FastMathController {
	
	@Autowired
	private FastMathService fastMathService;
	
	@GetMapping("/")
	public Equation getNewEquation() {
		try {
			return fastMathService.getNewEquation();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/")
	public Boolean postResults(@RequestBody PostResultsBodyParams body) {
		return fastMathService.CheckResults(body.getEq(), body.getResults());
	}
}
