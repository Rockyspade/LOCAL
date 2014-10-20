package com.permi.sqlite;

import StudentService.CourseService;
import StudentService.GradeService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.permi.sqlite.R;

public class DeleteC extends Activity {
	
	private EditText cnum;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deleteco);
		cnum=(EditText) findViewById(R.id.d_Cname);
		Button delete=(Button) findViewById(R.id.c_delete);
		delete.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View v){
			String  Cnum=cnum.getText().toString();
			if(Cnum.equals("")){
				new Builder(DeleteC.this).setMessage("课程号不能为空").show();
			}else {
				CourseService ss = new CourseService(DeleteC.this);
				/*String sql = "select * from Course where Cnum= ?";
				String[] cArgs = { Cnum };
				Cursor cursor = db.rawQuery(sql, cArgs);
				String sql = "select * from course where Cnum=? ";
				String[] selectionArgs = { Cnum };
				Cursor cursor = db.openHelper.getReadableDatabase().rawQuery(sql,selectionArgs);
				*/
				if (ss.find(Cnum)>0) {
					ss.delete(Cnum);
					GradeService s= new GradeService(DeleteC.this);
					s.deleteC(Cnum);
//					String[] s = new String[] { Cnum };
//				   db.delete("Course", "Cnum = ?", s);
//				   db.delete("Grade", "Cnum = ?", s);
				   new Builder(DeleteC.this).setMessage("删除成功").show();
				}else{
					new Builder(DeleteC.this).setMessage("无此课程信息").show();
				}
			}
		}
	}
}
