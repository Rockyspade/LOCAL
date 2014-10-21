package com.permi.sqlite;

import StudentService.StudentService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.permi.sqlite.R;

public class DeleteStu extends Activity{
	private EditText Snum;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deletestu);
		Snum=(EditText) findViewById(R.id.s_d_Snum);
		Button delete=(Button) findViewById(R.id.s_delete);
		delete.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View v){
			String  snum=Snum.getText().toString();
			if (snum.equals("")) {
				new Builder(DeleteStu.this).setMessage("ѧ�Ų���Ϊ��").show();
			}else {
				StudentService student=new StudentService(DeleteStu.this);
//				String sql = "select * from Student where Snum= ?";
//				String[] cArgs = { snum };
//				Cursor cursor = db.rawQuery(sql, cArgs);
				if (student.find(snum)>0) {
					student.delete(snum);
//					String[] s = new String[] { snum };
//				   db.delete("Student", "Cnum = ?", s);
				   new Builder(DeleteStu.this).setMessage("ɾ���ɹ�").show();
				} else {
					new Builder(DeleteStu.this).setMessage("�޴�ѧ����Ϣ").show();
				}
			}
		}
	}
}