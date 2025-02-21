package com.memoria.fastmath.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.memoria.fastmath.model.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer>{

}
