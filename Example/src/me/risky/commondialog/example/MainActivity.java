package me.risky.commondialog.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.risky.commondialog.CDConstants;
import me.risky.commondialog.CommonDialog;
import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<String> list = new ArrayList<String>();
		list.add("showDefaultDialogByMap");
		list.add("showDefaultDialogByString");
		list.add("showDefaultAlertDialog");
		list.add("showCustomThemeListDialog");
		list.add("showCustomThemeAlertDialog");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		
		listview = (ListView) findViewById(R.id.listview01);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				switch(position){
				case 0:
					showDefaulDialogByMap();
					break;
				case 1:
					showDefaulDialogByString();
					break;
				case 2:
					showDefaultAlertDialog();
					break;
				case 3:
					showCustomThemeListDialog();
					break;
				case 4:
					showCustomThemeAlertDialog();
					break;
				default:
					break;
				}
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private List<Object> testAddDataMap(){
    	List<Object> list = new ArrayList<Object>();
    	for(int i = 0; i < 8; i ++){
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put(CDConstants.DEF_MAP_KEY.BTN_TEXT, "testMap" + i*40);
    		map.put(CDConstants.DEF_MAP_KEY.BTN_BG, R.drawable.btn_list_item);
    		map.put(CDConstants.DEF_MAP_KEY.BTN_TEXT_SIZE, 18.0f);
    		map.put(CDConstants.DEF_MAP_KEY.BTN_TEXT_COLOR, Color.BLUE);
    		map.put(CDConstants.DEF_MAP_KEY.BTN_PADDING, 12);	
    		map.put(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE, getResources().getDrawable(R.drawable.btn_editor_press));	
    		map.put(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE_PADDING, -22);	
    		list.add(map);
    	}
    	return list;
    	
    }
    
    private List<Object> testAddDataString(){
    	List<Object> list = new ArrayList<Object>();
    	for(int i = 0; i < 4; i ++){
    		list.add("testStr" + i);
    	}
    	return list;
    }
    
    private void showDefaulDialogByMap(){
    	CommonDialog dialog = CommonDialog.create(this, CDConstants.DEFAULT_THEME_LIST);
    	dialog.setData(testAddDataMap());
    	dialog.show();
    }
    
    private void showDefaulDialogByString(){
    	CommonDialog dialog = CommonDialog.create(this, CDConstants.DEFAULT_THEME_LIST);
    	dialog.setData(testAddDataString());
    	dialog.show();
    }
    
    private void showDefaultAlertDialog(){
    	CommonDialog dialog = CommonDialog.create(this, CDConstants.DEFAULT_THEME_ALERT);
    	dialog.show();
    }
    
    
    private void showCustomThemeListDialog(){
    	CommonDialog dialog = CommonDialog.create(this, R.style.MyListDialog);
		dialog.setOnListItemClickListener(new OnListItemClickListener() {
			
			@Override
			public void onListItemClick(int position) {
				Toast.makeText(getApplicationContext(), "This is " + position, Toast.LENGTH_SHORT).show();
			}
		});
    	dialog.show();
    }
    
    private void showCustomThemeAlertDialog(){
    	CommonDialog dialog = CommonDialog.create(this, R.style.MyAlertDialog);
    	dialog.setOnPositiveClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "This is PositiveBtn.", Toast.LENGTH_SHORT).show();
			} 
		});
    	dialog.setOnNegativeClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "This is NegativeBtn.", Toast.LENGTH_SHORT).show();
			}
    		
    	});
    	dialog.show();
    	
    }
    
}
