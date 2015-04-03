package com.example.themax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	TextView textView1;
	Button Button1;
	Button Button2;
	EditText editText1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_view);

		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub
		textView1 = (TextView) findViewById(R.id.textView1);
		editText1 = (EditText) findViewById(R.id.editText1);
		Button1 = (Button) findViewById(R.id.button1);
		Button2 = (Button) findViewById(R.id.button2);
		Button1.setOnClickListener(this);
		Button2.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			String bread= editText1.getText().toString();
			Bundle basket=new Bundle();
			basket.putString("key", bread);
			Intent a=new Intent(Data.this, OpenendClass.class);
			a.putExtras(basket);
			startActivity(a);
			overridePendingTransition(R.anim.shrinkandrotate,R.anim.fadeout);
			
			break;
			
			
			
		case R.id.button2:
			
			Intent i=new Intent(Data.this, OpenendClass.class);
			startActivityForResult(i,0);
			
			
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
		Bundle basket=data.getExtras();
		String s=basket.getString("answer");
		textView1.setText(s);
		}
	}
	

}