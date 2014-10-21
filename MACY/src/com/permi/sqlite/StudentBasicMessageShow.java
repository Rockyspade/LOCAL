package com.permi.sqlite;

import java.util.List;

import model.Student;
import StudentService.StudentService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.permi.sqlite.R;

public class StudentBasicMessageShow extends Activity{
	private String snum;
	private List<Student> list;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectstudentshow);
    	Intent intent=getIntent();
		snum=intent.getStringExtra("Snum");
		StudentService st=new StudentService(StudentBasicMessageShow.this);
		list=st.getScrollData(snum);
//		String sql = "select * from Student where Snum= ?";
//		String[] cArgs = { snum };
//		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql, cArgs);
//		//new Builder(StudentBasicMessageShow.this).setMessage("学生信息"+cursor.getString(cursor.getColumnIndex("Sclass"))).show();
		CreateTable(list);
	}
	private void CreateTable(List<Student> list){
		TableLayout table=(TableLayout) findViewById(R.id.Student_TableLayout);
		
    	if(!list.isEmpty()){
			for(int i=0;i<list.size();++i){	
				
    			Student student=list.get(i);
				String pssex = student.getSsex();
			    String  psage = String.valueOf(student.getSage());
 		    	String psclass = student.getSclass();
				String psnum =student.getSnum();
		    	String psname = student.getSname();
				String phone =student.getSphone();
				TableRow row=new TableRow(this);
				TextView tsnum=new TextView(this);
				TextView tsclass=new TextView(this);
				TextView tsname=new TextView(this);
				TextView tssex=new TextView(this);
				TextView tsage=new TextView(this);
				TextView tsphone=new TextView(this);
				tsnum.setText(psnum);
				tsname.setText(psname);
				tsclass.setText(psclass);
			 	tsage.setText(psage);
				tsphone.setText(phone);
				tssex.setText(pssex);
				row.addView(tsnum);
				row.addView(tsclass);
				row.addView(tsname);
				row.addView(tssex);
     			row.addView(tsage);
				row.addView(tsphone);
				table.addView(row);
				} 
		}else{
			new Builder(StudentBasicMessageShow.this).setMessage("无此学生信息").show();
			}
		}

}
