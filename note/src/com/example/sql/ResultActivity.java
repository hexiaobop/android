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
		  	Display d = m.getDefaultDisplay();  //Ϊ��ȡ��Ļ����    
	       LayoutParams p = getWindow().getAttributes();  //��ȡ�Ի���ǰ�Ĳ���ֵ    
	       p.height = (int) (d.getHeight() * 0.5);   //�߶�����Ϊ��Ļ��1.0   
	       p.width = (int) (d.getWidth() * 0.4);    //�������Ϊ��Ļ��0.8   
	      
	       getWindow().setAttributes((android.view.WindowManager.LayoutParams) p);   
		texttitle = (TextView) findViewById(R.id.detail_title);
		textdata = (TextView) findViewById(R.id.detail_data);
		Intent intent = getIntent();
		texttitle.setText(intent.getStringExtra("title"));
		
		textdata.setText(intent.getStringExtra("data"));
		
			
	}
	

}
