package com.permi.sqlite;

import model.Grade;
import StudentService.GradeService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.permi.sqlite.R;

public class ReSetG extends Activity{
	private EditText snum;
	private EditText cnum;
	private EditText score;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setgrade);
		snum=(EditText) findViewById(R.id.g_s_Snum);
		cnum=(EditText) findViewById(R.id.g_s_Cnum);
		score=(EditText)findViewById(R.id.g_s_Score);
		Button insert=(Button)findViewById(R.id.g_set);
		insert.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View button) {

			if (button.getId() == R.id.g_set) {
				String Snum = snum.getText().toString();
				if (Snum.trim().equals("")) {
					Toast.makeText(ReSetG.this, "学号不许为空",
							Toast.LENGTH_LONG).show();
					return;
				} else {
					String Cnum = cnum.getText().toString();
					if (Cnum.trim().equals("")) {
						Toast.makeText(ReSetG.this, "课程号不许为空",
								Toast.LENGTH_LONG).show();
						return;

					} else {
						String Score = score.getText().toString();
						if (Score.trim().equals("")) {
							Toast.makeText(ReSetG.this, "成绩不许为空",
									Toast.LENGTH_LONG).show();
							return;

						} else {
							GradeService ss = new GradeService(ReSetG.this);
							Grade student = new Grade(Snum, Cnum,Score);
							if (ss.update(student) > 0) {
								Toast.makeText(ReSetG.this,
										"修改成功", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(ReSetG.this,
										"修改失败", Toast.LENGTH_LONG).show();
							}
						}
					}
				}
			}
		}
	}
}
