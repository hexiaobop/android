package com.example.sql;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.databasehandle.Handle;

public class ResultActivity extends Activity {
	
	public class lise implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch(v.getId())
			{
			case R.id.sure:
				try {
					onDestroy();
					ResultActivity.this.finish();
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case R.id.delete:				
				if(handle.delete(ResultActivity.id)){
					texttitle.setText("");
					textdata.setText("");
					Toast.makeText(ResultActivity.this, "��������Ͱ", Toast.LENGTH_SHORT).show();
					id ="";
				}
				else{
					;
				}
				break;
			default:break;
			}

		}

	}
	private TextView texttitle,textdata;
	private Button sure,delete;
	private static String id;
	private Handle handle;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.data);
		WindowManager m = getWindowManager();
		  	Display d = m.getDefaultDisplay();  //Ϊ��ȡ��Ļ����    
	       LayoutParams p = getWindow().getAttributes();  //��ȡ�Ի���ǰ�Ĳ���ֵ    
	       p.height = (int) (d.getHeight() * 0.8);   //�߶�����Ϊ��Ļ��1.0   
	       p.width = (int) (d.getWidth() * 0.9);    //�������Ϊ��Ļ��0.8   
	      
	       getWindow().setAttributes((android.view.WindowManager.LayoutParams) p); 
	      
	       handle = new Handle();
	       handle.dbhandle();
		texttitle = (TextView) findViewById(R.id.detail_title);
		textdata = (TextView) findViewById(R.id.detail_data);
		sure =(Button) findViewById(R.id.sure);
		delete = (Button) findViewById(R.id.delete);
		sure.setOnClickListener(new lise());
		delete.setOnClickListener(new lise());
		Intent intent = getIntent();
		id = intent.getStringExtra("id");
		texttitle.setText(intent.getStringExtra("title"));
		textdata.setText(intent.getStringExtra("data"));
		
		
			
	}

	

}
