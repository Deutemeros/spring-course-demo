package com.memoria.fastmath.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.service.MathFigureService;

@RequestMapping("/api/mathfigure")
public class MathFigureController {

	@Autowired
	private MathFigureService mathFigureService;

	@GetMapping("{id}")
	public Optional<MathFigure> getMathFigureByID(@RequestParam Integer id) {
		return mathFigureService.getMathFigureByID(id);
	}

	@GetMapping("field/{id}")
	public Iterable<MathFigure> getMathFigureByFieldID(@RequestParam Integer id) {
		return mathFigureService.getMathFiguresByFieldID(id);
	}
	
	@PostMapping("field")
	public Iterable<MathFigure> getMathFigureByFieldID(List<Integer> ids) {
		return mathFigureService.getMathFiguresByFieldIDs(ids);
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
	public MathFigure updateMathFigure(@RequestParam Integer id, MathFigure mathFigure) {
		mathFigure.setId(id);
		return mathFigureService.saveMathFigure(mathFigure);
	}

	@DeleteMapping("{id}")
	public void deleteMathFigureByID(@RequestParam Integer id) {
		mathFigureService.deleteMathFigureByID(id);
	}
}
