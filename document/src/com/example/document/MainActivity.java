package com.example.document;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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

		File root = new File("/mnt");
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

	}

}
