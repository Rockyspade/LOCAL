package com.permi.sqlite;


import com.permi.sqlite.R;

import model.Course;
import StudentService.CourseService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddC extends Activity {
	private EditText cname;
	private EditText cnum;
	private EditText ccredit;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addco);
		cname=(EditText) findViewById(R.id.c_i_Cname);
		cnum=(EditText) findViewById(R.id.c_i_Cnum);
		ccredit=(EditText)findViewById(R.id.c_i_Ccredit);
		Button insert=(Button)findViewById(R.id.c_i_insert);
		insert.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View button) {
			if (button.getId() == R.id.c_i_insert) {
				String Cnum = cnum.getText().toString();
				if (Cnum.trim().equals("")) {
					Toast.makeText(AddC.this, "�γ̺Ų���Ϊ��",Toast.LENGTH_LONG).show();
					return;
				} else {
					String Cname = cname.getText().toString();
					if (Cname.trim().equals("")) {
						Toast.makeText(AddC.this, "�γ�������Ϊ��",Toast.LENGTH_LONG).show();
						return;
					} else {
						String Ccredit = ccredit.getText().toString();
						if (Ccredit.trim().equals("")) {
							Toast.makeText(AddC.this, "ѧ�ֲ���Ϊ��",Toast.LENGTH_LONG).show();
							return;
						} else {
							Course student = new Course(Cnum, Cname,Integer.parseInt(Ccredit));
							CourseService ss = new CourseService(AddC.this);
							if (ss.save(student) > 0) {
								Toast.makeText(AddC.this, "��ӳɹ�",Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(AddC.this, "���ʧ��",Toast.LENGTH_LONG).show();
							}
						}
					}
				}
			}
		}
	}
}

