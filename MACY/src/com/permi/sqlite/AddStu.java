package com.permi.sqlite;

import model.Student;
import StudentService.StudentService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.permi.sqlite.R;

public class AddStu  extends Activity{
	private EditText sname;
	private EditText snum;
	private EditText sage;
	private EditText sclass;
	private EditText sphone;
	private EditText ssex;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addstu);
		sname =(EditText) findViewById(R.id.Sname);
		snum =(EditText) findViewById(R.id.Snum);
		sage =(EditText) findViewById(R.id.Sage);
		ssex=(EditText) findViewById(R.id.Ssex);
		sphone=(EditText) findViewById(R.id.Sphone);
		sclass=(EditText) findViewById(R.id.Sclass);
		Button insert =(Button)findViewById(R.id.s_insert);
		insert.setOnClickListener(new ButtonListener());
	}
	
	class ButtonListener implements OnClickListener{
		
		public void onClick(View button) {

			if (button.getId() == R.id.s_insert) {
				String Snum = snum.getText().toString();
				if (Snum.trim().equals("")) {
					Toast.makeText(AddStu.this, "ѧ�Ų���Ϊ��",Toast.LENGTH_LONG).show();
					return;
				}else {
					String Ssex = ssex.getText().toString();
					if (!(Ssex.trim().equals("��")||Ssex.trim().equals("Ů"))) {
						Toast.makeText(AddStu.this, "�Ա���д����",Toast.LENGTH_LONG).show();
						return;
					} else{
						String Sclass = sclass.getText().toString();
						if (Sclass.trim().equals("")) {
							Toast.makeText(AddStu.this, "�༶����Ϊ��",Toast.LENGTH_LONG).show();
							return;
						} else {
							String Sname = sname.getText().toString();
							if (Sname.trim().equals("")) {
								Toast.makeText(AddStu.this, "��������Ϊ��",Toast.LENGTH_LONG).show();
								return;
							} else {
								Integer Sage = Integer.parseInt(sage.getText().toString());
								String Sphone = sphone.getText().toString();
	
								Student student = new Student(Snum, Sclass, Sname,Ssex, Sage, Sphone);
								StudentService ss = new StudentService(AddStu.this);
								if (ss.save(student) > 0) {
									Toast.makeText(AddStu.this,"��ӳɹ�", Toast.LENGTH_LONG).show();
								} else {
									Toast.makeText(AddStu.this,"���ʧ��", Toast.LENGTH_LONG).show();
								}
							}
						}
					}
				}
			}
		}
	}
}
