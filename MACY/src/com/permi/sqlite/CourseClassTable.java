package com.permi.sqlite;

import java.util.List;

import model.table;
import StudentService.TableService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.permi.sqlite.R;

public class CourseClassTable extends Activity{
	private String cnum;
	private String sclass;
	private String sname;
	private String score;
	private String cname;
	List<table> list;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classcoursetableshow);
		TableService t=new TableService(CourseClassTable.this);
		list=t.getScrollData4();
		TableLayout table=(TableLayout) findViewById(R.id.ClassCourse_TableLayout);
		if(!list.isEmpty()){
			for (int i = 0; i < list.size(); ++i) {
				table ta=list.get(i);
				cnum=ta.getCnum();
				sclass=ta.getSclass();
				sname=ta.getSname();
				cname=ta.getCname();
				score=ta.getScore();
				TableRow row=new TableRow(this);
				TextView tcnum=new TextView(this);
				TextView tcname=new TextView(this);
				TextView tsname=new TextView(this);
				TextView tscore=new TextView(this);
				TextView tsclass=new TextView(this);
				tcnum.setText(cnum);
				tcname.setText(cname);
				tsname.setText(sname);
				tsclass.setText(sclass);
				tscore.setText(score);
				row.addView(tsclass);
				row.addView(tcnum);
				row.addView(tsname);
				row.addView(tcname);
				row.addView(tscore);
				table.addView(row);
			}
		}else{
			new Builder(CourseClassTable.this).setMessage("�޴���Ϣ").show();
		}
	}
}