package com.memoria.fastmath.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memoria.fastmath.model.Field;
import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.service.FieldService;
import com.memoria.fastmath.service.MathFigureService;

@RestController
@RequestMapping("/api/field")
public class FieldController {

	@Autowired
	private FieldService fieldService;
	
	@Autowired
	private MathFigureService mathFigureService;

	@GetMapping("{id}")
	public Optional<Field> getFieldByID(Integer id) {
		return fieldService.getFieldByID(id);
	}

	@GetMapping("{id}/mathFigure")
	public Iterable<MathFigure> getMathFigureByFieldID(@RequestParam Integer id) {
		return mathFigureService.getMathFiguresByFieldID(id);
	}
	
	@GetMapping("")
	public Iterable<Field> getAllFields() {
		return fieldService.getAllFields();
	}

	@PostMapping("")
	public Field createField(@RequestBody Field field) {
		return fieldService.saveField(field);
	}
	
	@PostMapping("{id}")
	public Field updateField(@RequestParam Integer id, @RequestBody Field field) {
		field.setId(id);
		return fieldService.saveField(field);
	}

	@DeleteMapping("{id}")
	public void deleteFieldByID(@RequestParam Integer id) {
		fieldService.deleteFieldByID(id);
	}
}
