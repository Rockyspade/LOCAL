package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DataSelect extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_select);
        Button studentBasicMessage =(Button) findViewById(R.id.data_select_1);
        Button gradeMessage =(Button) findViewById(R.id.data_select_2);
        Button courseMessage =(Button) findViewById(R.id.data_select_3);
        Button majarStudentMessage =(Button) findViewById(R.id.data_select_4);
        ButtonListener buttonlistener =new ButtonListener();
        studentBasicMessage.setOnClickListener(buttonlistener);
        gradeMessage.setOnClickListener(buttonlistener);
        courseMessage.setOnClickListener(buttonlistener);
        majarStudentMessage.setOnClickListener(buttonlistener);
	}
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.data_select_1:
				intent.setClass(DataSelect.this,StudentBasicMessage.class);
				DataSelect.this.startActivity(intent);	
				break;
			case R.id.data_select_2:
				intent.setClass(DataSelect.this,GradeMessage.class);
				DataSelect.this.startActivity(intent);	
				break;
			case R.id.data_select_3:
				intent.setClass(DataSelect.this,CourseMessage.class);
				DataSelect.this.startActivity(intent);	
				break;
			case R.id.data_select_4:
				intent.setClass(DataSelect.this,MajarStudentMessage.class);
				DataSelect.this.startActivity(intent);	
				break;
			default:
				break;
			}
    	}
    }
}

