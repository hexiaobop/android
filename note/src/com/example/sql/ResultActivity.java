package com.example.sql;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	private TextView texttitle,textdata;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.data);
		WindowManager m = getWindowManager();
		  	Display d = m.getDefaultDisplay();  //为获取屏幕宽、高    
	       LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值    
	       p.height = (int) (d.getHeight() * 0.5);   //高度设置为屏幕的1.0   
	       p.width = (int) (d.getWidth() * 0.4);    //宽度设置为屏幕的0.8   
	      
	       getWindow().setAttributes((android.view.WindowManager.LayoutParams) p);   
		texttitle = (TextView) findViewById(R.id.detail_title);
		textdata = (TextView) findViewById(R.id.detail_data);
		Intent intent = getIntent();
		texttitle.setText(intent.getStringExtra("title"));
		
		textdata.setText(intent.getStringExtra("data"));
		
			
	}
	

}
