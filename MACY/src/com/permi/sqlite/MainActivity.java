package com.permi.sqlite;

import com.permi.sqlite.Add;
import com.permi.sqlite.Delete;
import com.permi.sqlite.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button insert =(Button) findViewById(R.id.m_insert);
        Button delete =(Button) findViewById(R.id.m_delete);
        Button set =(Button) findViewById(R.id.m_set);
        Button select =(Button) findViewById(R.id.m_select);
        ButtonListener buttonlistener =new ButtonListener();
        insert.setOnClickListener(buttonlistener);
        delete.setOnClickListener(buttonlistener);
        set.setOnClickListener(buttonlistener);
        select.setOnClickListener(buttonlistener);
    }
    class ButtonListener implements OnClickListener{
    	public void onClick(View v){
    		int id=v.getId();
    		Intent intent =new Intent();
    		
    		switch (id) {
			case R.id.m_insert:
				intent.setClass(MainActivity.this,Add.class);
				MainActivity.this.startActivity(intent);	
				break;
			case R.id.m_delete:
				intent.setClass(MainActivity.this,Delete.class);
				MainActivity.this.startActivity(intent);	
				break;
			case R.id.m_select:
				intent.setClass(MainActivity.this,Select.class);
				MainActivity.this.startActivity(intent);	
				break;
			case R.id.m_set:
				intent.setClass(MainActivity.this,Reset.class);
				MainActivity.this.startActivity(intent);	
				break;
			default:
				break;
			}
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
