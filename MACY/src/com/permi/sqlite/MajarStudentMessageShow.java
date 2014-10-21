package com.permi.sqlite;

import java.util.List;

import model.stu;
import StudentService.StudentInfo;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.permi.sqlite.R;

public class MajarStudentMessageShow extends Activity {
	private String cnum;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent intent=getIntent();
		cnum=intent.getStringExtra("Cnum");
		setContentView(R.layout.majarstudentmessageshow);
		StudentInfo co=new StudentInfo(MajarStudentMessageShow.this);
		List<stu> list=co.getScrollData(cnum);
		CreateTable(list);

	}
	private void CreateTable(List<stu> list ){
		TableLayout table=(TableLayout) findViewById(R.id.Student_Course_TableLayout);
		if (!list.isEmpty()) {
			for (int i = 0; i <list.size(); ++i) {
    			stu s=list.get(i);
	    		String pcname = s.getCname();
				String psnum = s.getSnum();
				String psname = s.getSname();
				String pscore = s.getScore();
	
				TableRow row=new TableRow(this);
				TextView tcname=new TextView(this);
				TextView tsnum=new TextView(this);
				TextView tsname=new TextView(this);
				TextView tscore=new TextView(this);
				tcname.setText(pcname);
				tsnum.setText(psnum);
				tsname.setText(psname);
				tscore.setText(pscore);
				row.addView(tcname);
				row.addView(tsnum);
				row.addView(tsname);
				row.addView(tscore);
				table.addView(row);
				} 
		}else{
				new Builder(MajarStudentMessageShow.this).setMessage("无选此课程的学生").show();
			}
		}
}
