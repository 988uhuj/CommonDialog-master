package me.risky.commondialog.list;

import java.util.List;

import me.risky.commondialog.DConstants;
import me.risky.commondialog.DisplayDialog;
import me.risky.commondialog.R;
import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

public class DisplayList extends DisplayDialog{
	// Component
	private ListView listView;
	// Adapter
	private ListViewAdapter listViewAdapter;
	
	private static final int[] attrs = R.styleable.ListDialog;
	
	public DisplayList(Context context){
		super(context, DConstants.DEFAULT_THEME_LIST);
	}
	
	public DisplayList(Context context, int style){
		super(context, style);
	}

	@Override
	protected void initData() {
		super.initData();
		listViewAdapter = new ListViewAdapter(context);
	}

	@Override
	protected void initData(int style) {
		super.initData(style);
		
		// 无配置信息时的默认值
		final int noInt = DConstants.DEF_NO_VALUE.NO_INT;
		final float noFloat = DConstants.DEF_NO_VALUE.NO_FLOAT;
		
		// 从Style配置中读取数据
		TypedArray typedArray = context.obtainStyledAttributes(style, attrs);
		float customTextSize = typedArray.getDimension(R.styleable.ListDialog_android_textSize, noFloat); 
		int customTextColor = typedArray.getColor(R.styleable.ListDialog_android_textColor, noInt);
		int customItemBg = typedArray.getResourceId(R.styleable.ListDialog_itemBackground, noInt);
		int customMenus = typedArray.getResourceId(R.styleable.ListDialog_stringArray, noInt);
		int customTextAppearance = typedArray.getResourceId(R.styleable.ListDialog_itemTextAppearance, noInt);
		int customItemMargin = (int) typedArray.getDimension(R.styleable.ListDialog_itemMargin, noInt);
		int customItemMarginTB = (int) typedArray.getDimension(R.styleable.ListDialog_itemMarginTopAndBottom, noInt);
		int customItemBgHead = (int) typedArray.getResourceId(R.styleable.ListDialog_itemBackgroundHead, noInt);
		int customItemBgFoot = (int) typedArray.getResourceId(R.styleable.ListDialog_itemBackgroundFoot, noInt);
		int customItemWidth = (int) typedArray.getDimension(R.styleable.ListDialog_itemWidth, noInt);
		int customItemHeight = (int) typedArray.getDimension(R.styleable.ListDialog_itemHeight, noInt);
		typedArray.recycle();
		
		// 保存配置数据
		if(customTextColor != noInt) dialogData.setListTextColor(customTextColor);
		if(customTextSize != noFloat) dialogData.setListTextSize(customTextSize);
		if(customItemBg != noInt) dialogData.setListItemBg(customItemBg);
		if(customMenus != noInt) dialogData.setListMenus(context.getResources().getStringArray(customMenus));
		if(customItemMargin != noInt) dialogData.setListItemMagin(customItemMargin);
		if(customItemMarginTB != noInt) dialogData.setListItemMaginTopAndBottom(customItemMarginTB);
		if(customItemBgHead != noInt) dialogData.setListItemBgHead(customItemBgHead);
		if(customItemBgFoot != noInt) dialogData.setListItemBgFoot(customItemBgFoot);
		if(customItemWidth != noInt) dialogData.setListItemWidth(customItemWidth);
		if(customItemHeight != noInt) dialogData.setListItemHeight(customItemHeight);
		dialogData.setListTextAppearance(customTextAppearance);
		
		// --------------通过保存的属性设置相应控件的样式----------------
		if(dialogData.getListTextColor() != null) listViewAdapter.setTextColor(dialogData.getListTextColor());
		if(dialogData.getListTextSize() != null) listViewAdapter.setTextSize(dialogData.getListTextSize());
		if(dialogData.getListItemBg() != null) listViewAdapter.setItemBg(dialogData.getListItemBg());
		if(dialogData.getListMenus() != null) listViewAdapter.setArray(dialogData.getListMenus());
		if(dialogData.getListTextAppearance() != null) listViewAdapter.setTextAppearance(dialogData.getListTextAppearance());
		if(dialogData.getListItemMagin() != null) listViewAdapter.setItemMargin(dialogData.getListItemMagin());
		if(dialogData.getListItemMaginTopAndBottom() != null) listViewAdapter.setItemMarginTopAndBottom(dialogData.getListItemMaginTopAndBottom());
		if(dialogData.getListItemBgHead() != null) listViewAdapter.setItemBgHead(dialogData.getListItemBgHead());
		if(dialogData.getListItemBgFoot() != null) listViewAdapter.setItemBgFoot(dialogData.getListItemBgFoot());
		if(dialogData.getListItemWidth() != null) listViewAdapter.setItemWidth(dialogData.getListItemWidth());
		if(dialogData.getListItemHeight() != null) listViewAdapter.setItemHeight(dialogData.getListItemHeight());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.display_list);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void findView() {
		super.findView();
		listView = (ListView) baseView.findViewById(R.id.listview);
	}

	@Override
	protected void initComponent() {
		super.initComponent();
		listView.setAdapter(listViewAdapter);
		
		setSelfOnClickListener();
	}
	
	
	/**
	 * 点击监听事件，默认点击即隐藏
	 */
	private OnListItemClickListener listener = new OnListItemClickListener() {
		
		@Override
		public void onListItemClick(int position) {
			autoDismiss();
		}
	};
	
	
	private void setSelfOnClickListener(){
		listViewAdapter.setOnListItemClickListener(listener);
	}
	
	
	// 外部接口
	@Override
	public void setOnListItemClickListener(OnListItemClickListener listener){
		listViewAdapter.setOnListItemClickListener(listener);
	}
	
	@Override
	public void setData(List<Object> list){
		listViewAdapter.setList(list);
	}
	
	
}



