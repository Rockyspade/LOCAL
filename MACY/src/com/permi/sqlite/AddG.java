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

public class AddG  extends Activity{
	private EditText snum;
	private EditText cnum;
	private EditText score;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addgrade);
		snum=(EditText) findViewById(R.id.g_Snum);
		cnum=(EditText) findViewById(R.id.g_Cnum);
		score=(EditText)findViewById(R.id.Score);
		Button insert=(Button)findViewById(R.id.g_insert);
		insert.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View button) {

			if (button.getId() == R.id.g_insert) {
				String Snum = snum.getText().toString();
				if (Snum.trim().equals("")) {
					Toast.makeText(AddG.this, "ѧ�Ų���Ϊ��",Toast.LENGTH_LONG).show();
					return;
				} else {
					String Cnum = cnum.getText().toString();
					if (Cnum.trim().equals("")) {
						Toast.makeText(AddG.this, "�γ̺Ų���Ϊ��",Toast.LENGTH_LONG).show();
						return;
					} else {
						String Score = score.getText().toString();
						if (Score.trim().equals("")) {
							Toast.makeText(AddG.this, "�ɼ�����Ϊ��",Toast.LENGTH_LONG).show();
							return;
						} else {
							Grade student = new Grade(Snum, Cnum, Score);
							GradeService ss = new GradeService(AddG.this);
							
							if (ss.save(student) > 0) {
								Toast.makeText(AddG.this, "��ӳɹ�",Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(AddG.this, "���ʧ��",Toast.LENGTH_LONG).show();
							}
						}
					}
				}
			}
		}
	}
}
