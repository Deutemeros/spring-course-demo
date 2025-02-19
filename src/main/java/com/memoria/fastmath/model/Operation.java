package com.memoria.fastmath.model;

import java.util.Random;

public enum Operation {
	ADDITION,
	SUBSTRACTION,
	MULTIPLICATION,
	DIVISION,
	MODULO;

    private static final Random PRNG = new Random();

    private static final Operation[] operations = values();

    public static Operation randomOperation() { 
	    return operations[PRNG.nextInt(operations.length)]; 
	}
    
    public String toString() {
		switch (this) {
		case ADDITION:
			return "+";
		case SUBSTRACTION:
			return "-";
		case MULTIPLICATION:
			return "*";
		case DIVISION:
			return "/";
		case MODULO:
			return "%";
		default:
			return "";
		}
	}
}
