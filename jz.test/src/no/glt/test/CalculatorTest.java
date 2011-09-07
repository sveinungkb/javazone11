package no.glt.test;

import no.glt.Calculator;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

	Calculator mCalculator;
	
	protected void setUp() throws Exception {
		super.setUp();
		mCalculator = new Calculator();
	}
	
	public void testInitialValue(){
		assertTrue("Calculator is expected to have 0 as initial value", mCalculator.getCurrentValue() == 0);
	}
	
	public void testAddFive() {
		int before = mCalculator.getCurrentValue();
		int expected = before +  5;
		int actual = mCalculator.add(5);
		assertEquals(expected, actual);
		assertEquals(actual, mCalculator.getCurrentValue());
	}

	public void testSubtractTwo() {
		int earlierValue = mCalculator.getCurrentValue();
		int expected = earlierValue -  2;
		int actual = mCalculator.subtract(2);
		assertEquals(expected, actual);
		assertEquals(actual, mCalculator.getCurrentValue());
	}

	public void testDivideByThree() {
		int earlierValue = mCalculator.getCurrentValue();
		int expected = earlierValue / 3;
		int actual = mCalculator.divide(3);
		assertEquals(expected, actual);
		assertEquals(actual, mCalculator.getCurrentValue());
	}

	public void testMultiplyByFour() {
		int earlierValue = mCalculator.getCurrentValue();
		int expected = earlierValue *4;
		int actual = mCalculator.multiply(4);
		assertEquals(expected, actual);
		assertEquals(actual, mCalculator.getCurrentValue());
	}
	
	public void testFailing() {
		assertTrue(true);
	}

	public void testReset()
	{
		assertTrue("Calculator is expected to have 0 as value after reset", mCalculator.getCurrentValue() == 0);
	}
}
