package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class StudentBasicMessage extends Activity {
	private EditText Snum;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectstudent);
		Snum=(EditText) findViewById(R.id.s_select_Snum);
		Button select=(Button) findViewById(R.id.s_s_select);
		select.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View v){
			String  snum=Snum.getText().toString();
			if (snum.equals("")) {
				new Builder(StudentBasicMessage.this).setMessage("学号不能为空").show();
			}else {				
					Intent intent=new Intent(StudentBasicMessage.this,StudentBasicMessageShow.class);
					intent.putExtra("Snum", snum);
					StudentBasicMessage.this.startActivity(intent);
					}
				}
			}
}