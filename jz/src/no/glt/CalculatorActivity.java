package no.glt;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity implements OnClickListener {
	private static final String LOGTAG = "JavaZone";
	private Button mButtonAdd;
	private Button mButtonMultiply;
	private Button mButtonSubtract;
	private Button mButtonDivide;
	private EditText mTextInput;
	private Button mButtonClear;
	private Calculator mCalculator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);

		findViews();
		setClickListeners();
		
		mCalculator = new Calculator();
	}

	private void findViews() {
		mButtonAdd = findButton(R.id.button_add);
		mButtonSubtract = findButton(R.id.button_subtract);
		mButtonMultiply = findButton(R.id.button_multiply);
		mButtonDivide = findButton(R.id.button_divide);
		mButtonClear = findButton(R.id.button_clear);
		
		mTextInput = (EditText) findTextView(R.id.text_number_input);
	}

	private TextView findTextView(int id) {
		return (TextView) findViewById(id);
	}

	private Button findButton(int id) {
		return (Button) findViewById(id);
	}
	
	private void setClickListeners() {
		mButtonAdd.setOnClickListener(this);
		mButtonDivide.setOnClickListener(this);
		mButtonSubtract.setOnClickListener(this);
		mButtonMultiply.setOnClickListener(this);
		mButtonClear.setOnClickListener(this);
	}


	public void onClick(View clickableView) {
		if(clickableView == mButtonClear){
			mTextInput.setText("");
			mCalculator.reset();
			return;
		}
		
		else if(mTextInput.getText().length() == 0) return;
		
		int oldValue = mCalculator.getCurrentValue();
		int number = Integer.parseInt(mTextInput.getText().toString());
		int newValue = 0;
		
		String operator = "unknown";
		
		if(clickableView == mButtonAdd){
			newValue = mCalculator.add(number);
			operator = " + ";
		}
		else if(clickableView == mButtonSubtract){
			newValue = mCalculator.subtract(number);
			operator = " - ";
		}
		else if(clickableView == mButtonDivide){
			newValue = mCalculator.divide(number);
			operator = " / ";
		}
		else if(clickableView == mButtonMultiply){
			newValue = mCalculator.multiply(number);
			operator = " * ";
		}
		
		Log.d(LOGTAG, oldValue + operator + number + " = " + newValue);
		
		mTextInput.setText(Integer.toString(mCalculator.getCurrentValue()));
		mTextInput.setSelection(0, mTextInput.getText().length());
	}
}