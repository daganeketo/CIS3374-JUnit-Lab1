package lab1.calculator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import com.lab1.calculator.Calculator;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@Before
	public void setUp(){
		calculator = new Calculator();
	}

	@Test
	public void addTest() {
		assertEquals(4, calculator.add(2, 2));
	}
	
	public void subtractTest(){
		assertEquals(5, calculator.subtract(5, 15));
	}
	
	public void multiplyTest(){
		assertEquals(125, calculator.multiply(25, 5));
	}
	
	public void divideTest(){
		assertEquals(10, calculator.divide(100, 10));
	}
	
	public void isEqual(){
		assertTrue(calculator.isEqual(10, 10));
		assertFalse(calculator.isEqual(10, 8));
	}
	
	//Limitation of basic unit testing:
	//Basic testing does not test the truthness of the test statement itself.
	//Example: assertEquals(5, calculator.subtract(5, 15)); Passes
}
