package com.memoria.fastmath.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.memoria.fastmath.model.Equation;
import com.memoria.fastmath.model.Operation;

import lombok.Data;

@Data
@Service
public class FastMathService {
	
	public Equation getNewEquation() throws Exception {
		Random rand = new Random();
		Operation operation = Operation.randomOperation();

		Equation eq = new Equation();
		eq.setOp(operation);
		
		Integer a, b;
		
		switch (operation) {
		case ADDITION:
			a = rand.nextInt(999);
			b = rand.nextInt(999);
			eq.setA(a);
			eq.setB(b);
			eq.setResults(a+b);
			break;
		case SUBSTRACTION:
			a = rand.nextInt(999);
			b = rand.nextInt(999);
			eq.setA(Math.max(a, b));
			eq.setB(Math.min(a, b));
			eq.setResults(Math.abs(a-b));
			break;
		case MULTIPLICATION:
			a = rand.nextInt(99);
			b = rand.nextInt(99);
			eq.setA(a);
			eq.setB(b);
			eq.setResults(a*b);
			break;
		case DIVISION:
			a = rand.nextInt(99);
			b = rand.nextInt(99);
			eq.setA(a*b);
			eq.setB(b);
			eq.setResults(a);
			break;
		case MODULO:
			a = rand.nextInt(999);
			b = rand.nextInt(999);
			eq.setA(Math.max(a, b));
			eq.setB(Math.min(a, b));
			eq.setResults(a%b);
			break;
		default:
			throw new Exception("Invalid Operation");
		}
		
		return eq;
	}
	
	public Boolean CheckResults(Equation eq, Integer results) {
		return eq.getResults().equals(results);
	}
	
}
