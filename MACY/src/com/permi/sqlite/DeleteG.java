package com.permi.sqlite;

import StudentService.GradeService;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.permi.sqlite.R;

public class DeleteG extends Activity{
	private EditText Cnum;
	private EditText Snum;
//	private SQLiteDatabase db;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deletegrade);
		Cnum=(EditText) findViewById(R.id.g_d_Cnum);
		Snum=(EditText) findViewById(R.id.g_d_Snum);
		Button delete=(Button) findViewById(R.id.g_delete);
		delete.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View v){
			String  cnum=Cnum.getText().toString();
			String snum=Snum.getText().toString();
			if (cnum.equals("")||snum.equals("")) {
				new Builder(DeleteG.this).setMessage("成绩信息不能为空").show();
			}else {
				GradeService s= new GradeService(DeleteG.this);
//				String sql = "select * from Grade where Cnum= ? and Snum = ?";
//				String[] gArgs = { cnum, snum };
//				Cursor cursor = this.openHelper.rawQuery(sql, gArgs);
				if (s.find(cnum, snum)>0) {
					if(s.deleteG(cnum, snum)>0){
//				String[] s = new String[] { cnum, snum };
//				db.delete("Grade", "Cnum= ? and Snum = ?", s);
						new Builder(DeleteG.this).setMessage("删除成功").show();
					}else{
						new Builder(DeleteG.this).setMessage("删除失败").show();
					}
				} else {
					new Builder(DeleteG.this).setMessage("无此成绩信息").show();
				}
			}
		}
	}
}

