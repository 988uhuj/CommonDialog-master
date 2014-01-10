package me.risky.commondialog;

import java.util.List;

import me.risky.commondialog.ListViewAdapter.OnListItemClickListener;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;
/**
 * 
 * 继承Dialog
 * 
 * @author chenupt@gmail.com
 * 
 * @version 1.0
 * 
 */
public class CommonListDialog extends Dialog {

	public static String TAG = "CommonDialog";
	private Context context;
	// Component
	private ListView listView;
	private RelativeLayout layout;
	
	// Adapter
	private ListViewAdapter listViewAdapter;
	  
	// Data
	private DialogData dialogData;
	
	//------------------------------
	
	
	/**
	 * 默认加载默认主题
	 * @param context
	 */
	public CommonListDialog(Context context) {
		super(context, R.style.Theme_CommonListDialog);
		this.context = context;
		initData();
	}
	/**
	 * 加载自定义主题
	 * @param context
	 * @param theme
	 */
	public CommonListDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
		initData(theme);
	}
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_list_dialog);
		
		findView();
		initComponent();
		setSelfOnClickListener();
		
		Log.d(TAG, "dialog onCreate");
	}
	
	private void initData(){
		listViewAdapter = new ListViewAdapter(context);
		dialogData = new DialogData();
	}
	/**
	 * 通过传入的style加载属性
	 * @param style
	 */
	private void initData(int style){
		initData();
		
		// 无配置信息时的默认值
		final int noTextColor = CDConstants.DEF_NO_VALUE.NO_TEXTCOLOR;
		final float noTextSize = CDConstants.DEF_NO_VALUE.NO_TEXTSIZE;
		final int noX = CDConstants.DEF_NO_VALUE.NO_X;
		final int noY = CDConstants.DEF_NO_VALUE.NO_Y;
		final int noWidth = CDConstants.DEF_NO_VALUE.NO_WIDTH;
		final int noHeight = CDConstants.DEF_NO_VALUE.NO＿HEIGHT;
		final int noAnim = CDConstants.DEF_NO_VALUE.NO_ANIM;
		final int noGravity = CDConstants.DEF_NO_VALUE.NO_GRAVITY;
		final int noItemBg = CDConstants.DEF_NO_VALUE.NO_ITEMBG;
		final int noMenus = CDConstants.DEF_NO_VALUE.NO_MENUS;
		final int noBg = CDConstants.DEF_NO_VALUE.NO_BG;
		
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, R.styleable.CommonDialog);
		
		int customBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_background, noBg); 
		int customX = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_x, noX);
		int customY = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_y, noY);
		int customWidth = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_width, 0);
		int customHeight = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_height, 0);
		int customGravity = commonTypedArray.getInteger(R.styleable.CommonDialog_android_gravity, noGravity);
		int customAnim = commonTypedArray.getResourceId(R.styleable.CommonDialog_anim, noAnim);
		commonTypedArray.recycle();
		
		
		// 从Style配置中读取数据
		TypedArray typedArray = context.obtainStyledAttributes(style, R.styleable.ListDialog);
		
		float customTextSize = typedArray.getDimension(R.styleable.ListDialog_android_textSize, noTextSize); 
		int customTextColor = typedArray.getColor(R.styleable.ListDialog_android_textColor, noTextColor);
		int customItemBg = typedArray.getResourceId(R.styleable.ListDialog_itemBackground, noItemBg);
		int customMenus = typedArray.getResourceId(R.styleable.ListDialog_stringArray, noMenus);
		int customTextAppearance = typedArray.getResourceId(R.styleable.ListDialog_android_textAppearance, -1);
		
		typedArray.recycle();
		 
		
		// 保存配置数据
		if(customTextColor != noTextColor) dialogData.setTextColor(customTextColor);
		if(customTextSize != noTextSize) dialogData.setTextSize(customTextSize);
		if(customBg != noBg) dialogData.setBg(customBg);
		if(customX != noX) dialogData.setX(customX);	
		if(customY != noY) dialogData.setY(customY);
		if(customWidth != noWidth) dialogData.setWidth(customWidth);
		if(customHeight != noHeight) dialogData.setHeight(customHeight);
		if(customGravity != noGravity) dialogData.setGravity(customGravity);
		if(customAnim != noAnim) dialogData.setAnim(customAnim);
		if(customItemBg != noItemBg) dialogData.setItemBg(customItemBg);
		if(customMenus != noMenus) dialogData.setMenus(context.getResources().getStringArray(customMenus));
		dialogData.setTextAppearance(customTextAppearance);
	}
	
	private void findView(){
		listView = (ListView) findViewById(R.id.listview);
		layout = (RelativeLayout) findViewById(R.id.main);
	}
	
	private void initComponent(){
		listView.setAdapter(listViewAdapter);
		
		// --------------通过保存的属性设置相应控件的样式----------------
		if(dialogData.getBg() != null) layout.setBackgroundResource(dialogData.getBg());
		if(dialogData.getPadding() != null) layout.setPadding(dialogData.getPadding(), dialogData.getPadding(), dialogData.getPadding(), dialogData.getPadding());
		if(dialogData.getTextColor() != null) listViewAdapter.setTextColor(dialogData.getTextColor());
		if(dialogData.getTextSize() != null) listViewAdapter.setTextSize(dialogData.getTextSize());
		if(dialogData.getItemBg() != null) listViewAdapter.setItemBg(dialogData.getItemBg());
		if(dialogData.getMenus() != null) listViewAdapter.setArray(dialogData.getMenus());
		if(dialogData.getTextAppearance() != null) listViewAdapter.setTextAppearance(dialogData.getTextAppearance());
		
		initWindowAttributes();
		
		// --------------end----------------
	}
	
	/**
	 * 设置dialog窗口属性
	 */
	private void initWindowAttributes(){
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        if(dialogData.getGravity() != null) dialogWindow.setGravity(dialogData.getGravity());
        if(dialogData.getX() != null) lp.x = dialogData.getX(); 
        if(dialogData.getY() != null) lp.y = dialogData.getY(); 
        if(dialogData.getWidth() != null) lp.width = dialogData.getWidth(); 
        if(dialogData.getHeight() != null) lp.height = dialogData.getHeight();
        if(dialogData.getAlpha() != null) lp.alpha = dialogData.getAlpha(); 
        dialogWindow.setAttributes(lp);
        
        if(dialogData.getAnim() != null) dialogWindow.setWindowAnimations(dialogData.getAnim());
	}
	/**
	 * 点击监听事件，默认点击即隐藏
	 */
	private OnListItemClickListener listener = new OnListItemClickListener() {
		
		@Override
		public void onListItemClick(int position) {
			Log.d(TAG, "click" + position);
			// 点击按钮隐藏对话框 TODO 设置属性
			dismiss();
		}
	};
	
	private void setSelfOnClickListener(){
		listViewAdapter.setOnListItemClickListener(listener);
	}
	
	
	
	
	//--------外部接口----------
	
	public void setData(List<Object> list){
		listViewAdapter.setList(list);
	}
	
	public void setShowTitle(boolean show){
		dialogData.setShowTitle(show);
	}
	
	public boolean isShowTitle(){
		return dialogData.isShowTitle();
	}
	
	public void setWidth(int width){
		dialogData.setWidth(width);
	}
	
	public void setHeight(int height){
		dialogData.setHeight(height);
	}
	
	public void setGravity(int gravity){
		dialogData.setGravity(gravity);
	}
	
	public void setItemView(int res){
		listViewAdapter.setItemView(res);
	}
	
	public void setOnListItemClickListener(OnListItemClickListener listener){
		listViewAdapter.setOnListItemClickListener(listener);
	}
	
	public void setShowCancelBtn(boolean show){
		dialogData.setShowCancelBtn(show);
	}
	
	public void setPadding(int padding){
		dialogData.setPadding(padding);
	}
	
	public void setAnim(int style){
		dialogData.setAnim(style);
	}
	public void setBackground(int bg){
		dialogData.setBg(bg);
	}
	
}
