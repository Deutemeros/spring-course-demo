package com.memoria.fastmath.model;

import lombok.Data;

@Data
public class Equation {
	
	private Operation op;
	private Integer a;
	private Integer b;
	private Integer results;

	public Equation() {
		this.op = Operation.ADDITION;
		this.a = 0;
		this.b = 0;
		this.results = 0;
	}
	public Equation(Operation op, Integer a, Integer b, Integer results) {
		this.op = op;
		this.a = a;
		this.b = b;
		this.results = results;
	}
	
	public String toString() {
		return String.format("{ a: %d, b: %d, op: %s, results: %d}", this.a, this.b, this.op, this.results); 
	}
}
