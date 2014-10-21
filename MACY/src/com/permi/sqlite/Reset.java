package com.permi.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.permi.sqlite.R;

public class Reset extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        Button set_S =(Button) findViewById(R.id.set_S);
        Button set_C =(Button) findViewById(R.id.set_C);
        Button set_G =(Button) findViewById(R.id.set_G);
        ButtonListener buttonListener =new ButtonListener();
        set_S.setOnClickListener(buttonListener);
        set_C.setOnClickListener(buttonListener);
        set_G.setOnClickListener(buttonListener);
	}
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.set_C:
				intent.setClass(Reset.this,ReSetC.class);
				Reset.this.startActivity(intent);	
				break;
			case R.id.set_G:
				intent.setClass(Reset.this,ReSetG.class);
				Reset.this.startActivity(intent);	
				break;
			case R.id.set_S:
				intent.setClass(Reset.this,ReSetStu.class);
				Reset.this.startActivity(intent);	
				break;
			}
    	} 
	}
}

