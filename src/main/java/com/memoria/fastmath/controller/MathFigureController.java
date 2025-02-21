package com.memoria.fastmath.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.service.MathFigureService;

@RequestMapping("/api/mathfigure")
public class MathFigureController {

	@Autowired
	private MathFigureService mathFigureService;

	@GetMapping("{id}")
	public Optional<MathFigure> getMathFigureByID(Integer id) {
		return mathFigureService.getMathFigureByID(id);
	}

	@GetMapping("")
	public Iterable<MathFigure> getAllMathFigures() {
		return mathFigureService.getAllMathFigures();
	}

	@PostMapping("")
	public MathFigure createMathFigure(MathFigure mathFigure) {
		return mathFigureService.saveMathFigure(mathFigure);
	}
	
	@PostMapping("{id}")
	public MathFigure updateMathFigure(Integer id, MathFigure mathFigure) {
		mathFigure.setId(id);
		return mathFigureService.saveMathFigure(mathFigure);
	}

	@DeleteMapping("{id}")
	public void deleteMathFigureByID(Integer id) {
		mathFigureService.deleteMathFigureByID(id);
	}
}
