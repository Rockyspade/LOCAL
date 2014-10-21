package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DataStatistics extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datastatistics);
        Button GradeTable1 =(Button) findViewById(R.id.d_t_1);
        Button GradeTable2 =(Button) findViewById(R.id.d_t_2);
        Button UnderLine =(Button) findViewById(R.id.d_t_3);
        Button ReTry =(Button) findViewById(R.id.d_t_4);
        ButtonListener buttonlistener =new ButtonListener();
        GradeTable1.setOnClickListener(buttonlistener);
        GradeTable2.setOnClickListener(buttonlistener);
        UnderLine.setOnClickListener(buttonlistener);
        ReTry.setOnClickListener(buttonlistener);
    }
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.d_t_1:
				intent.setClass(DataStatistics.this,ClassCourseTable.class);
				DataStatistics.this.startActivity(intent);	
				break;
			case R.id.d_t_2:
				intent.setClass(DataStatistics.this,CourseClassTable.class);
				DataStatistics.this.startActivity(intent);	
				break;
			case R.id.d_t_3:
				intent.setClass(DataStatistics.this,Under60Table.class);
				DataStatistics.this.startActivity(intent);	
				break;
			case R.id.d_t_4:
				intent.setClass(DataStatistics.this,ReExamTable.class);
				DataStatistics.this.startActivity(intent);	
				break;
			default:
				break;
			}
    	}
    }
}
