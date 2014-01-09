package me.risky.commondialog.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.risky.commondialog.CDConstants;
import me.risky.commondialog.CommonDialog;
import me.risky.commondialog.CommonListDialog;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<String> list = new ArrayList<String>();
		list.add("showDialogByMap");
		list.add("showDialogByString");
		list.add("showCustomDialog");
		list.add("showThemeDialog");
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		
		listview = (ListView) findViewById(R.id.listview01);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				switch(position){
				case 0:
					showDialogByMap();
					break;
				case 1:
					showDialogByString();
					break;
				case 2:
					showCustomDialog();
					break;
				case 3:
					showThemeDialog();
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
    
    private void showDialogByMap(){
    	CommonListDialog dialog = (CommonListDialog)CommonDialog.createDialog(this, R.style.MyDialog);
    	dialog.setData(testAddDataMap());
    	dialog.show();
    }
    
    private void showDialogByString(){
//    	CommonDialog commonDialog = new CommonDialog(this);
//    	commonDialog.setData(testAddDataString());
//		commonDialog.show();
    }
    
    private void showCustomDialog(){
    	// show full screen
    	DisplayMetrics dm = new DisplayMetrics();
    	getWindowManager().getDefaultDisplay().getMetrics(dm);
    	int dispWidth = dm.widthPixels;
    	
//    	CommonDialog commonDialog = new CommonDialog(this);
//    	commonDialog.setData(testAddDataString());
//    	commonDialog.setBackground(getResources().getDrawable(R.drawable.login_input));
//    	commonDialog.setGravity(Gravity.TOP);
//    	commonDialog.setWidth(dispWidth);
//    	commonDialog.setPadding(20);
//    	commonDialog.setAnim(R.style.common_dialog_window_anim_top);
//		commonDialog.show();
    }
    
    private void showThemeDialog(){
//    	CommonDialog commonDialog = new CommonDialog(this, R.style.MyDialog);
//		commonDialog.show();
    }
}
