package com.memoria.fastmath.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoria.fastmath.model.Field;
import com.memoria.fastmath.repository.FieldRepository;

@Service
public class FieldService {
	
	@Autowired
	private FieldRepository repository;
	
	public Optional<Field> getFieldByID(Integer id) {
		return repository.findById(id);
	}
	
	public Iterable<Field> getAllFields() {
		return repository.findAll();
	}
	
	public Field saveField(Field field) {
		return repository.save(field);
	}
	
	public void deleteFieldByID(Integer id) {
		repository.deleteById(id);
	}
}
