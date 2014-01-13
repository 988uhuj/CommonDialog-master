package me.risky.commondialog.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.risky.commondialog.DConstants;
import me.risky.commondialog.DisplayDialog;
import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
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
		list.add("showDefaultSpaceListDialog");
		list.add("showCustomThemeListDialog");
		list.add("showCustomThemeAlertDialog");
		list.add("showEmptyDialog");
		
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
					showDefaultSpaceListDialog();
					break;
				case 4:
					showCustomThemeListDialog();
					break;
				case 5:
					showCustomThemeAlertDialog();
					break;
				case 6:
					showEmptyDialog();
					break;
				default:
					break;
				}
				
			}
		});
		
		
	}
	
	private List<Object> testAddDataMap(){
    	List<Object> list = new ArrayList<Object>();
    	for(int i = 0; i < 8; i ++){
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put(DConstants.DEF_MAP_KEY.BTN_TEXT, "testMap" + i*40);
    		map.put(DConstants.DEF_MAP_KEY.BTN_BG, R.drawable.btn_list_item);
    		map.put(DConstants.DEF_MAP_KEY.BTN_TEXT_SIZE, 18.0f);
    		map.put(DConstants.DEF_MAP_KEY.BTN_TEXT_COLOR, Color.BLUE);
    		map.put(DConstants.DEF_MAP_KEY.BTN_PADDING, 12);	
    		map.put(DConstants.DEF_MAP_KEY.BTN_DRAWABLE, getResources().getDrawable(R.drawable.btn_editor_press));	
    		map.put(DConstants.DEF_MAP_KEY.BTN_DRAWABLE_PADDING, -22);	
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
    	DisplayDialog dialog = DisplayDialog.create(this, DConstants.DEFAULT_THEME_LIST);
    	dialog.setData(testAddDataMap());
    	dialog.show();
    }
    
    private void showDefaulDialogByString(){
    	DisplayDialog dialog = DisplayDialog.create(this, DConstants.DEFAULT_THEME_LIST);
    	dialog.setData(testAddDataString());
    	dialog.show();
    }
    
    private void showDefaultAlertDialog(){
    	DisplayDialog dialog = DisplayDialog.create(this, DConstants.DEFAULT_THEME_ALERT);
    	dialog.show();
    }
    private void showDefaultSpaceListDialog(){
    	DisplayDialog dialog = DisplayDialog.create(this, DConstants.DEFAULT_THEME_LIST_SPACE);
    	dialog.setData(testAddDataString());
    	dialog.show();
    }
    
    private void showCustomThemeListDialog(){
    	DisplayDialog dialog = DisplayDialog.create(this, R.style.MyListDialog);
		dialog.setOnListItemClickListener(new OnListItemClickListener() {
			
			@Override
			public void onListItemClick(int position) {
				Toast.makeText(getApplicationContext(), "This is " + position, Toast.LENGTH_SHORT).show();
			}
		});
    	dialog.show();
    }
    
    private void showCustomThemeAlertDialog(){
    	DisplayDialog dialog = DisplayDialog.create(this, R.style.MyAlertDialog);
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
    private void showEmptyDialog(){
    	DisplayDialog dialog = DisplayDialog.create(this, DConstants.DEFAULT_EMTPY);
    	dialog.show();
    }
}
