package no.glt;

public class Calculator {
	private int mCurrentValue = 0;
	
	public Calculator() {
		reset();
	}
	
	public int getCurrentValue(){
		return mCurrentValue;
	}
	
	public int add(int number){
		mCurrentValue += number;
		return mCurrentValue;
	}
	
	public int subtract(int number){
		mCurrentValue -= number;
		return mCurrentValue;
	}
	
	public int divide(int number){
		mCurrentValue /= number;
		return mCurrentValue;
	}
	
	public int multiply(int number){
		mCurrentValue *= number;
		return mCurrentValue;
	}
	
	public void reset(){
		mCurrentValue = 0;
	}
}
