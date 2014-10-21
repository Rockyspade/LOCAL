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
public class ReSetStu extends Activity{
	private EditText sname;
	private EditText snum;
	private EditText sage;
	private EditText sclass;
	private EditText sphone;
	private EditText ssex;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setstu);
		sname =(EditText) findViewById(R.id.s_s_Sname);
		snum =(EditText) findViewById(R.id.s_s_Snum);
		sage =(EditText) findViewById(R.id.s_s_Sage);
		ssex=(EditText) findViewById(R.id.s_s_Ssex);
		sphone=(EditText) findViewById(R.id.s_s_Sphone);
		sclass=(EditText) findViewById(R.id.s_s_Sclass);
		Button reset =(Button)findViewById(R.id.s_set);
		reset.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
			
		public void onClick(View button) {

			if (button.getId() == R.id.s_set) {
				String Snum = snum.getText().toString();
				if (Snum.trim().equals("")) {
					Toast.makeText(ReSetStu.this, "学号不许为空",Toast.LENGTH_LONG).show();
					return;
				} else {
					String Sclass = sclass.getText().toString();
					if (Sclass.trim().equals("")) {
						Toast.makeText(ReSetStu.this, "班级不许为空",Toast.LENGTH_LONG).show();
						return;
					} else {
						String Sname = sname.getText().toString();
						if (Sname.trim().equals("")) {
							Toast.makeText(ReSetStu.this,"姓名不许为空", Toast.LENGTH_LONG).show();
							return;
						}else {
							String Ssex = ssex.getText().toString();
							if (!(Ssex.trim().equals("男")||Ssex.trim().equals("女"))) {
								Toast.makeText(ReSetStu.this, "性别填写错误",Toast.LENGTH_LONG).show();
								return;
							} else {
								Integer Sage = Integer.parseInt(sage.getText().toString());
								String Sphone = sphone.getText().toString();
								Student student = new Student(Snum, Sclass, Sname,Ssex, Sage, Sphone);
								StudentService ss = new StudentService(ReSetStu.this);
								if (ss.update(student) > 0) {
									Toast.makeText(ReSetStu.this,"修改成功", Toast.LENGTH_LONG).show();
								} else {
									Toast.makeText(ReSetStu.this,"修改失败", Toast.LENGTH_LONG).show();
								}
							}
						}
					}
				}
			}
		}
	}
}
