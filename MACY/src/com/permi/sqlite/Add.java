package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Add extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        Button insert_S =(Button) findViewById(R.id.add_S);
        Button insert_C =(Button) findViewById(R.id.add_C);
        Button insert_G =(Button) findViewById(R.id.add_G);
        ButtonListener buttonListener =new ButtonListener();
        insert_S.setOnClickListener(buttonListener);
        insert_C.setOnClickListener(buttonListener);
        insert_G.setOnClickListener(buttonListener);
	}
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.add_C:
				intent.setClass(Add.this,AddC.class);
				Add.this.startActivity(intent);	
				break;
			case R.id.add_G:
				intent.setClass(Add.this,AddG.class);
				Add.this.startActivity(intent);	
				break;
			case R.id.add_S:
				intent.setClass(Add.this,AddStu.class);
				Add.this.startActivity(intent);	
				break;
			}
    	} 
	}
}
