package com.example.sql;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.databasehandle.Handle;

public class MainActivity extends ActionBarActivity {
private EditText title,data;
private ListView list;
private Button save;
private Handle handle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handle = new Handle();
		handle.dbhandle(this);
		title = (EditText) findViewById(R.id.title);
		data = (EditText) findViewById(R.id.data);
		list = (ListView) findViewById(R.id.list);
		save = (Button) findViewById(R.id.save);
		disable();
		save();
	
		list.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			     
	      

	}
		});
		
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	
	
	
	private void save()
	{
		save.setOnClickListener(new OnClickListener() {			
		public void onClick(View v) {
			String titleE = title.getText().toString();
			String dataE = data.getText().toString();
			SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd");     
			Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间     
			String  date   =   formatter.format(curDate);  
			if(titleE.equals("")||dataE.equals(""))
			{
				Toast.makeText(MainActivity.this, "输完再保存，慌个啥呢", Toast.LENGTH_LONG).show();
			}
			else{
				if(handle.add(titleE,dataE,date)){
					Toast.makeText(MainActivity.this, "已保存今日干货", Toast.LENGTH_LONG).show();
					title.setText(null);
					data.setText(null);
					
					disable();
					
				}
				else{
					Toast.makeText(MainActivity.this, "没有保存到数据库", Toast.LENGTH_LONG).show();
				}
				
			}		
		}
	});
		
	}
	public void disable()
	{
		Cursor cursor = handle.findall();
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.disable,cursor , new String[]{"note_title","note_date"}, new int[]{R.id.list_title,R.id.list_time});
		
		list.setAdapter(adapter);
	}
}
