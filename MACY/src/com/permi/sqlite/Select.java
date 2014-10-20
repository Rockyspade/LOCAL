package com.permi.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.permi.sqlite.R;
public class Select extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        Button select =(Button) findViewById(R.id.data_select);
        Button tongji =(Button) findViewById(R.id.data_statistics);
        ButtonListener buttonlistener =new ButtonListener();
        select.setOnClickListener(buttonlistener);
        tongji.setOnClickListener(buttonlistener);
	}
	class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		switch (id) {
			case R.id.data_select:
				intent.setClass(Select.this,DataSelect.class);
				Select.this.startActivity(intent);	
				break;
			case R.id.data_statistics:
				intent.setClass(Select.this,DataStatistics.class);
				Select.this.startActivity(intent);	
				break;
			default:
				break;
			}
    	}
    }
}

