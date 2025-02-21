package com.memoria.fastmath.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "fields")
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Name")
	private String name;

	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true,
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "Field_ID")
	private List<MathFigure> mathFigure = new ArrayList<MathFigure>();
}
