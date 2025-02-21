package com.memoria.fastmath.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memoria.fastmath.model.Field;
import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.service.FieldService;

@RequestMapping("/api/field")
public class FieldController {

	@Autowired
	private FieldService fieldService;

	@GetMapping("{id}")
	public Optional<Field> getFieldByID(Integer id) {
		return fieldService.getFieldByID(id);
	}

	@GetMapping("")
	public Iterable<Field> getAllFields() {
		return fieldService.getAllFields();
	}

	@PostMapping("")
	public Field createField(Field field) {
		return fieldService.saveField(field);
	}
	
	@PostMapping("{id}")
	public Field updateField(Integer id, Field field) {
		field.setId(id);
		return fieldService.saveField(field);
	}

	@DeleteMapping("{id}")
	public void deleteFieldByID(Integer id) {
		fieldService.deleteFieldByID(id);
	}
}
