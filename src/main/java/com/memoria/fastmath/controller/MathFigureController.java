package com.memoria.fastmath.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.model.MathFigureInput;
import com.memoria.fastmath.service.MathFigureService;

@RestController
@RequestMapping("/api/mathfigure")
public class MathFigureController {

	@Autowired
	private MathFigureService mathFigureService;

	@GetMapping("{id}")
	public Optional<MathFigure> getMathFigureByID(@PathVariable Integer id) {
		return mathFigureService.getMathFigureByID(id);
	}

	@GetMapping("")
	public Iterable<MathFigure> getAllMathFigures() {
		return mathFigureService.getAllMathFigures();
	}

	@PostMapping("")
	public MathFigure createMathFigure(@RequestBody MathFigureInput mathFigureInput) {
		return mathFigureService.saveMathFigure(mathFigureInput);
	}
	
	@PostMapping("{id}")
	public MathFigure updateMathFigure(@PathVariable Integer id, @RequestBody MathFigureInput mathFigureInput) {
		mathFigureInput.setId(id);
		return mathFigureService.saveMathFigure(mathFigureInput);
	}

	@DeleteMapping("{id}")
	public void deleteMathFigureByID(@PathVariable Integer id) {
		mathFigureService.deleteMathFigureByID(id);
	}
}
