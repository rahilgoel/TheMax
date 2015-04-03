package com.example.themax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenendClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	TextView textView1, textView2;
	Button button1;
	RadioGroup rgAnswers;
	String gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_group);

		initialize();
		// Bundle gotBasket =getIntent().getExtras();
		// gotBread=gotBasket.getString("key");
		// textView1.setText(gotBread);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		rgAnswers = (RadioGroup) findViewById(R.id.rgAnswers);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		rgAnswers.setOnCheckedChangeListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.radioButton1:
			setData = "probably right";

			break;
		case R.id.radioButton2:
			setData = "naah";
			break;

		case R.id.radioButton3:
			setData = "ohh yeah";
			break;

		}
		textView2.setText(setData);
	}

}
