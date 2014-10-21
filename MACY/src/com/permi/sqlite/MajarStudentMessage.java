package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MajarStudentMessage extends Activity {
	private EditText Cnum;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.majarstudentmessage);
		Cnum=(EditText) findViewById(R.id.m_select_Cnum);
		Button select=(Button) findViewById(R.id.m_s_select);
		select.setOnClickListener(new ButtonListener());
	}
	class ButtonListener implements OnClickListener{
		public void onClick(View v){
			String  cnum=Cnum.getText().toString();
			if (cnum.equals("")) {
				new Builder(MajarStudentMessage.this).setMessage("课程号不能为空").show();
			}else {
				Intent intent=new Intent(MajarStudentMessage.this,MajarStudentMessageShow.class);
				intent.putExtra("Cnum", cnum);
				MajarStudentMessage.this.startActivity(intent);
				}
			}
		}
}
