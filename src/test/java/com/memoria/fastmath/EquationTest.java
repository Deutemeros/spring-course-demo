package com.memoria.fastmath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.memoria.fastmath.model.Equation;
import com.memoria.fastmath.model.Operation;

@SpringBootTest
public class EquationTest {
	
	@Test
	public void testToString() {
		List<Tuple<Equation, String>> equations = new ArrayList<Tuple<Equation, String>>();
		equations.add(new Tuple<Equation, String>(new Equation(Operation.ADDITION, 2, 3, 5), "2+3=5"));
		equations.add(new Tuple<Equation, String>(new Equation(Operation.SUBSTRACTION, 3, 2, 1), "3-2=1"));
		
		for (Tuple<Equation, String> tuple : equations) {
			Assert.isTrue(tuple.x.toString().equals(tuple.y), String.format("expected %s, actual %s", tuple.y, tuple.x.toString()));
		}
	}
	
}
