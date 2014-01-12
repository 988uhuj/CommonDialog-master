package me.risky.commondialog.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import me.risky.commondialog.CDConstants;
import me.risky.commondialog.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 
 * Adapter用于对菜单列表的控制
 * 
 * @author chenupt@gmail.com
 * 
 * @version 1.0
 *
 */
public class ListViewAdapter extends BaseAdapter {
	
	//============定义变量=================
	
	
	public static String TAG = "Adapter";
	
	private ViewHolder holder;
	private LayoutInflater layoutInflater;
	private Context context;
	
	/**
	 * 菜单数据和属性
	 */
	private ListAdapterData listAdapterData;
	/**
	 * 菜单点击监听
	 */
	private List<OnListItemClickListener> listenerList;
	
	
	
	//=============定义方法==================
	
	
	public ListViewAdapter(Context c) {
		super();
		this.context = c;
		layoutInflater = (LayoutInflater) LayoutInflater.from(c);
		
		listAdapterData = new ListAdapterData();
		// 设置默认itemview
		listAdapterData.setItemView(R.layout.listview_item);
		
		// 实例化回调接口列表
		listenerList = new ArrayList<ListViewAdapter.OnListItemClickListener>();
	}
	/**
	 *  设置列表为数据源
	 * @param list
	 */
	public void setList(List<Object> list){
		listAdapterData.setList(list);
		if(listAdapterData.getList().get(0) instanceof Map){
			Log.d(TAG, "Map");
			listAdapterData.setMap(true);
		}else{
			Log.d(TAG, "String");
			listAdapterData.setMap(false);
		}
	}
	/**
	 * 设置字符串数组为数据源
	 * @param array
	 */
	public void setArray(Object[] array){
		listAdapterData.setList(Arrays.asList(array));
		if(listAdapterData.getList().get(0) instanceof Map){
			Log.d(TAG, "Map");
			listAdapterData.setMap(true);
		}else{
			Log.d(TAG, "String");
			listAdapterData.setMap(false);
		}
	}
	
	@Override
	public int getCount() {
		return listAdapterData.getList().size();
	}

	@Override
	public Object getItem(int position) {
		return listAdapterData.getList().get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (null == convertView) {
			convertView = layoutInflater.inflate(listAdapterData.getItemView(), null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView.findViewById(R.id.itemBtn);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// 设置样式
		setStyle(holder.textView);
		// 设置数据
		if(listAdapterData.isMap()){
			// map 时包含自定义属性
			Map<String, Object> item = (Map<String, Object>)listAdapterData.getList().get(position); // 获取当前项数据
			setItemAttr(holder.textView, item, position);
		}else{
			// String 只显示文本
			String item = (String) listAdapterData.getList().get(position);
			setItemAttr(holder.textView, item, position);
		}
		
		return convertView;
	}
	
	/**
	 * 通过MAP设置样式
	 * @param textview
	 * @param item
	 * @param position
	 */
	private void setItemAttr(TextView textview, Map<String, Object> item, int position){
		textview.setText((String)item.get(CDConstants.DEF_MAP_KEY.BTN_TEXT));
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_TEXT_SIZE) != null){
			textview.setTextSize((Float)item.get(CDConstants.DEF_MAP_KEY.BTN_TEXT_SIZE));
		}
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_TEXT_COLOR) != null){
			textview.setTextColor((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_TEXT_COLOR));
		}
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_BG) != null){
			textview.setBackgroundResource((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_BG));
		}
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_PADDING) != null){
			textview.setPadding(((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_PADDING)),
					((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_PADDING)), 
					((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_PADDING)), 
					((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_PADDING)));
		}
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE) != null){
			Drawable d = (Drawable)item.get(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE);
			d.setBounds(0, 0, d.getMinimumWidth(), d.getMinimumHeight());
			textview.setCompoundDrawables(d, null, null, null);
		}
		if(item.get(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE_PADDING) != null){
			textview.setCompoundDrawablePadding((Integer)item.get(CDConstants.DEF_MAP_KEY.BTN_DRAWABLE_PADDING));
		}
		
		
		textview.setTag(position);
		textview.setOnClickListener(onClickListener);
	}
	/**
	 *  只设置文字
	 * @param textview
	 * @param item
	 * @param position
	 */
	private void setItemAttr(TextView textview, String item, int position){
		textview.setText(item);
		textview.setTag(position);
		textview.setOnClickListener(onClickListener);
	}
	
	/**
	 *  设置配置文件中style样式
	 * @param textview
	 */
	private void setStyle(TextView textview){
		if(listAdapterData.getAppearance() != null) textview.setTextAppearance(context, listAdapterData.getAppearance());
		if(listAdapterData.getTextColor() != null) textview.setTextColor(listAdapterData.getTextColor());
		if(listAdapterData.getTextSize() != null) textview.setTextSize(listAdapterData.getTextSize());
		if(listAdapterData.getItemBg() != null) textview.setBackgroundResource(listAdapterData.getItemBg());
	}
	
	
    private class ViewHolder {
    	TextView textView;
    }
    
    /**
     * menu点击监听
     */
    private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			int position = (Integer) ((TextView) view).getTag();
			Log.d(TAG, "onClick = " + position);

			for (OnListItemClickListener listener : listenerList) {
				listener.onListItemClick(position);
			}
		}
	};
	
	
	// ------------- 回调接口 (允许注册多个) ------------
	
	public void setOnListItemClickListener(OnListItemClickListener listener){
		this.listenerList.add(listener);
	}
	
	public interface OnListItemClickListener {  
	    public void onListItemClick(int position);  
	} 
	
	
	

    // TODO 外部接口。设置Item属性，可添加
    public void setItemView(int res){
    	listAdapterData.setItemView(res);
    }
    public void setTextSize(float textSize){
    	listAdapterData.setTextSize(textSize);
    }
    public void setTextColor(int textColor){
    	listAdapterData.setTextColor(textColor);
    }
    public void setItemBg(int itemBgId){
    	listAdapterData.setItemBg(itemBgId);
    }
    public void setTextAppearance(int textAppearance){
    	listAdapterData.setAppearance(textAppearance);
    }
}
