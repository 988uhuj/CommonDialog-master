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
 * Adapter���ڶԲ˵��б�Ŀ���
 * 
 * @author chenupt@gmail.com
 * 
 * @version 1.0
 *
 */
public class ListViewAdapter extends BaseAdapter {
	
	//============�������=================
	
	
	public static String TAG = "Adapter";
	
	private ViewHolder holder;
	private LayoutInflater layoutInflater;
	private Context context;
	
	/**
	 * �˵����ݺ�����
	 */
	private ListAdapterData listAdapterData;
	/**
	 * �˵��������
	 */
	private List<OnListItemClickListener> listenerList;
	
	
	
	//=============���巽��==================
	
	
	public ListViewAdapter(Context c) {
		super();
		this.context = c;
		layoutInflater = (LayoutInflater) LayoutInflater.from(c);
		
		listAdapterData = new ListAdapterData();
		// ����Ĭ��itemview
		listAdapterData.setItemView(R.layout.listview_item);
		
		// ʵ�����ص��ӿ��б�
		listenerList = new ArrayList<ListViewAdapter.OnListItemClickListener>();
	}
	/**
	 *  �����б�Ϊ����Դ
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
	 * �����ַ�������Ϊ����Դ
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
		// ������ʽ
		setStyle(holder.textView);
		// ��������
		if(listAdapterData.isMap()){
			// map ʱ�����Զ�������
			Map<String, Object> item = (Map<String, Object>)listAdapterData.getList().get(position); // ��ȡ��ǰ������
			setItemAttr(holder.textView, item, position);
		}else{
			// String ֻ��ʾ�ı�
			String item = (String) listAdapterData.getList().get(position);
			setItemAttr(holder.textView, item, position);
		}
		
		return convertView;
	}
	
	/**
	 * ͨ��MAP������ʽ
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
	 *  ֻ��������
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
	 *  ���������ļ���style��ʽ
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
     * menu�������
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
	
	
	// ------------- �ص��ӿ� (����ע����) ------------
	
	public void setOnListItemClickListener(OnListItemClickListener listener){
		this.listenerList.add(listener);
	}
	
	public interface OnListItemClickListener {  
	    public void onListItemClick(int position);  
	} 
	
	
	

    // TODO �ⲿ�ӿڡ�����Item���ԣ������
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
