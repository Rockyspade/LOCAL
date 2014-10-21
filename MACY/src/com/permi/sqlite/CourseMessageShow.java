package com.permi.sqlite;

import java.util.List;

import model.Course;
import StudentService.CourseService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.permi.sqlite.R;

public class CourseMessageShow extends Activity {
	private String cnum;
	private List<Course> list;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent intent=getIntent();
		cnum=intent.getStringExtra("Cnum");
		setContentView(R.layout.coursemessageshow);
		CourseService course=new CourseService(CourseMessageShow.this);
		list=course.getScrollData(cnum);
		CreateTable(list);
	}
	private void CreateTable(List<Course> list){
		TableLayout table=(TableLayout) findViewById(R.id.Course_TableLayout);
		if(!list.isEmpty()){
			for(int i=0;i<list.size();++i){
				Course course=list.get(i);
				String pcnum=course.getCnum();
				String pcname = course.getCname();
				String  pccredit = String.valueOf(course.getCcredit());
				TableRow row=new TableRow(this);
				TextView tcnum=new TextView(this);
				TextView tcname=new TextView(this);
				TextView tccredit=new TextView(this);
				tcnum.setText(pcnum);
				tcname.setText(pcname);
				tccredit.setText(pccredit);
				row.addView(tcnum);
				row.addView(tcname);
				row.addView(tccredit);
				table.addView(row);
			} 
		}else{
			new Builder(CourseMessageShow.this).setMessage("无此课程信息").show();
		}
	}
}
