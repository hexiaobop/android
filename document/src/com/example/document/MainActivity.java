package com.example.document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView list;
	private Button btn;
	private TextView tv;
	private File currentParent;
	private File[] currentFiles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);   

		setContentView(R.layout.activity_main);
		list = (ListView) findViewById(R.id.sd_files);
		btn = (Button) findViewById(R.id.btn_back);
		tv = (TextView) findViewById(R.id.sd_path);
		havefile("/");
		
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				TextView  t = (TextView) arg1.findViewById(R.id.tv_file_info);
				if (currentFiles[arg2].isFile())
				{
					return;
				}
				File[] tmp = currentFiles[arg2].listFiles();
				if (tmp == null || tmp.length == 0)
				{
					Toast.makeText(MainActivity.this, "空文件夹", Toast.LENGTH_SHORT).show();
				} else
				{
					currentParent = currentFiles[arg2];
					currentFiles = tmp;
					firstlist(currentFiles);
				}
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					try {
						if(!currentParent.getCanonicalPath().equals("/"))
						{
							currentParent = currentParent.getParentFile();
							currentFiles = currentParent.listFiles();
							firstlist(currentFiles);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			
			}});
	}
	public void havefile(String path)
	{
		File root = new File(path);
		if (root.exists()) {
			
			currentParent = root;
			currentFiles = currentParent.listFiles();
			firstlist(currentFiles);
		}
		else{
			System.out.println("no  found sdcard");
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void firstlist(File[] files) {
		List<Map<String, Object>> firstlist = new ArrayList<Map<String, Object>>();
		for (File f : files) {

			Map<String, Object> map = new HashMap<String, Object>();
			if (f.isDirectory()) {
				map.put("icon", R.drawable.wenjianjia);
			} else {
				map.put("icon", R.drawable.wenjian);
				
			}
			map.put("fileName", f.getName());
			firstlist.add(map);

		}
		SimpleAdapter simplea = new SimpleAdapter(this, firstlist,
				R.layout.ilist_item, new String[] { "icon", "fileName" }, new int[] {
						R.id.img_file_icon, R.id.tv_file_info });
		list.setAdapter(simplea);
		try
		{
			tv.setText("当前路径为： "+currentParent.getCanonicalPath());
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}




}
