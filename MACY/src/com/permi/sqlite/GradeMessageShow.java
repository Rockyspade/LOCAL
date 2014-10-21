package com.permi.sqlite;

import java.util.List;

import model.Grade;
import StudentService.GradeService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.permi.sqlite.R;

public class GradeMessageShow extends Activity {
	private String snum;
	private List<Grade> list;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent intent=getIntent();
		snum=intent.getStringExtra("Snum");
		setContentView(R.layout.grademessageshoe);
		GradeService gd=new GradeService(GradeMessageShow.this);
		list=gd.getScrollData(snum);
		CreateTable(list);
	}
	private void CreateTable(List<Grade> list){
		TableLayout table=(TableLayout) findViewById(R.id.Grade_TableLayout);
		if (!list.isEmpty()) {
			for(int i=0;i<list.size();++i){
				Grade grade=list.get(i);
				String psnum=grade.getSnum();
				String pscore=grade.getScore();
				String pcnum=grade.getCnum();
				TableRow row=new TableRow(this);
				TextView tsnum=new TextView(this);
				TextView tcnum=new TextView(this);
				TextView tscore=new TextView(this);
				tsnum.setText(psnum);
				tcnum.setText(pcnum);
				tscore.setText(pscore);
				row.addView(tsnum);
				row.addView(tcnum);
				row.addView(tscore);
				table.addView(row);
			} 
		}else{
			new Builder(GradeMessageShow.this).setMessage("无此学生的成绩信息").show();
		}
	}

}
