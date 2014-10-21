package com.permi.sqlite;

import com.permi.sqlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Delete extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        Button delete_S =(Button) findViewById(R.id.delete_S);
        Button delete_C =(Button) findViewById(R.id.delete_C);
        Button delete_G =(Button) findViewById(R.id.delete_G);
        ButtonListener buttonListener =new ButtonListener();
        delete_S.setOnClickListener(buttonListener);
        delete_C.setOnClickListener(buttonListener);
        delete_G.setOnClickListener(buttonListener);
	}
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.delete_C:
				intent.setClass(Delete.this,DeleteC.class);
				Delete.this.startActivity(intent);	
				break;
			case R.id.delete_G:
				intent.setClass(Delete.this,DeleteG.class);
				Delete.this.startActivity(intent);	
				break;
			case R.id.delete_S:
				intent.setClass(Delete.this,DeleteStu.class);
				Delete.this.startActivity(intent);	
				break;
			}
    	} 
	}
}

