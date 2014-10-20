package com.permi.sqlite;

import model.Course;
import StudentService.CourseService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.permi.sqlite.R;

public class ReSetC extends Activity {
	private EditText cname;
	private EditText cnum;
	private EditText ccredit;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setco);
		cname=(EditText) findViewById(R.id.c_s_Cname);
		cnum=(EditText) findViewById(R.id.c_s_Cnum);
		ccredit=(EditText)findViewById(R.id.c_s_Ccredit);
		Button insert=(Button)findViewById(R.id.c_set);
		insert.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View button) {

			if (button.getId() == R.id.c_set) {
				String Cnum = cnum.getText().toString();
				if (Cnum.trim().equals("")) {
					Toast.makeText(ReSetC.this, "课程号不许为空",
							Toast.LENGTH_LONG).show();
					return;
				} else {
					String Cname = cname.getText().toString();
					if (Cname.trim().equals("")) {
						Toast.makeText(ReSetC.this, "课程名不许为空",
								Toast.LENGTH_LONG).show();
						return;

					} else {
						String Ccredit = ccredit.getText().toString();
						if (Ccredit.trim().equals("")) {
							Toast.makeText(ReSetC.this,
									"学分不许为空", Toast.LENGTH_LONG).show();
							return;

						} else {
							
							Course student = new Course(Cnum, Cname, Integer.parseInt(Ccredit)
							);
							CourseService ss = new CourseService(
									ReSetC.this);
							if (ss.update(student) > 0) {
								Toast.makeText(ReSetC.this,
										"修改成功", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(ReSetC.this,
										"修改失败", Toast.LENGTH_LONG).show();
							}
						}
					}
				}
			}
		}
	}
}
