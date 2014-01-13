package me.risky.commondialog;

import java.util.List;

import me.risky.commondialog.alert.DisplayAlert;
import me.risky.commondialog.list.DisplayList;
import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayDialog extends Dialog implements IDisplay{
	
	protected Context context;
	protected DisplayData dialogData;
	private TextView titleTV;
	
	private ViewGroup mainLayout;
	private Button positiveBtn;
	private Button negativeBtn;
	private ViewGroup positiveLayout;
	private ViewGroup negativeLayout;
	private LinearLayout buttonLayout;
	protected ViewGroup baseView;
	
	private static final int style = R.style.CommonAlertDialog;
	private static final int[] attrs = R.styleable.CommonDialog;

	protected DisplayDialog(Context context) {
		super(context, style);
		this.context = context;
		
		initData(style);
	}
	
	protected DisplayDialog(Context context, int style){
		super(context, style);
		this.context = context;
		
		initData(style);
	}
	
	
	protected void initData(){
		dialogData = new DisplayData();
	}
	
	protected void initData(int style){
		initData();
		// 无配置信息时的默认值
		final int noInt = DConstants.DEF_NO_VALUE.NO_INT;
		final float noFloat = DConstants.DEF_NO_VALUE.NO_FLOAT;
		
		//---------------------读取保存共有属性-----------------------
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, attrs);
		// 对话框类别
		int customType = commonTypedArray.getInteger(R.styleable.CommonDialog_type, noInt);
		// Window
		int customBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_background, noInt);
		int customX = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_x, noInt);
		int customY = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_y, noInt);
		int customWidth = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_width, noInt);
		int customHeight = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_height, noInt);
		float customWidthF = commonTypedArray.getFraction(R.styleable.CommonDialog_widthFraction, 1, 100, noFloat);
		float customHeightF = commonTypedArray.getFraction(R.styleable.CommonDialog_heightFraction, 1, 100, noFloat);
		int customGravity = commonTypedArray.getInteger(R.styleable.CommonDialog_android_gravity, noInt);
		int customAnim = commonTypedArray.getResourceId(R.styleable.CommonDialog_anim, noInt);
		boolean customAutoDismiss = commonTypedArray.getBoolean(R.styleable.CommonDialog_autoDismiss, true);
		boolean customShowButtons = commonTypedArray.getBoolean(R.styleable.CommonDialog_showButtons, true);
		
		// Title
		int customTitleTextColor = commonTypedArray.getColor(R.styleable.CommonDialog_titleTextColor, noInt); 
		float customTitleTextSize = commonTypedArray.getDimension(R.styleable.CommonDialog_titleTextSize, noInt); 
		String customTitle = commonTypedArray.getString(R.styleable.CommonDialog_title);
		int customTitleBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_titleBackground, noInt);
		int customTitleTextAppearance = commonTypedArray.getResourceId(R.styleable.CommonDialog_titleTextAppearance,  noInt);
		
		// Button
		boolean customIsShowPositiveBtn = commonTypedArray.getBoolean(R.styleable.CommonDialog_positiveButton, true);
		String customPositiveBtnText = commonTypedArray.getString(R.styleable.CommonDialog_positiveButtonText);
		int customPositiveBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_positiveButtonBg, noInt);
		boolean customIsShowNegativeBtn = commonTypedArray.getBoolean(R.styleable.CommonDialog_negativeButton, true);
		String customNegativeBtnText = commonTypedArray.getString(R.styleable.CommonDialog_negativeButtonText);
		int customNegativeBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_negativeButtonBg, noInt);
		
		int customButtonPadding = (int)commonTypedArray.getDimension(R.styleable.CommonDialog_buttonPadding, noFloat);
		int customButtonMargin = (int)commonTypedArray.getDimension(R.styleable.CommonDialog_buttonMargin, noFloat);
		int customButtonTextAppearance = commonTypedArray.getResourceId(R.styleable.CommonDialog_buttonTextAppearance, noInt);
		commonTypedArray.recycle();
		
		
		// 保存配置数据 
		if(customType != noInt) dialogData.setType(customType);
		// save Window
		if(customBg != noInt) dialogData.setBg(customBg);
		if(customX != noInt) dialogData.setX(customX);	
		if(customY != noInt) dialogData.setY(customY);
		if(customWidth != noInt) dialogData.setWidth(customWidth);
		if(customHeight != noInt) dialogData.setHeight(customHeight);
		if(customWidthF != noFloat) dialogData.setWidthFraction(customWidthF);
		if(customHeightF != noFloat) dialogData.setWidthFraction(customHeightF);
		if(customGravity != noInt) dialogData.setGravity(customGravity);
		if(customAnim != noInt) dialogData.setAnim(customAnim);
		dialogData.setAutoDismiss(customAutoDismiss);
		dialogData.setShowButtons(customShowButtons);
		
		// Save title
		if(customTitleTextColor != noFloat) dialogData.setTitleTextColor(customTitleTextColor);
		if(customTitleTextSize != noInt) dialogData.setTitleTextSize(customTitleTextSize);
		if(customTitle != null) dialogData.setTitle(customTitle);
		if(customTitleBg != noInt) dialogData.setTitleBackground(customTitleBg);
		if(customTitleTextAppearance != noInt) dialogData.setTitleTextAppearance(customTitleTextAppearance);
		
		// Save button
		dialogData.setShowPositiveBtn(customIsShowPositiveBtn);
		if(customPositiveBtnText != null) dialogData.setPositiveBtnText(customPositiveBtnText);
		if(customPositiveBg != noInt) dialogData.setPositiveBtnBg(customPositiveBg);
		dialogData.setShowNegativeBtn(customIsShowNegativeBtn);
		if(customNegativeBtnText != null)dialogData.setNegativeBtnText(customNegativeBtnText);
		if(customNegativeBg != noInt) dialogData.setNegativeBtnBg(customNegativeBg);
		if(customButtonPadding != noFloat) dialogData.setButtonPadding(customButtonPadding);
		if(customButtonMargin != noFloat) dialogData.setButtonMargin(customButtonMargin);	
		if(customButtonTextAppearance != noInt) dialogData.setButtonTextAppearance(customButtonTextAppearance);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diaplay_base);
		setTypeView();
		findView();
		initComponent();
	}
	
	protected void findView(){
		// 共有的控件
		titleTV = (TextView) findViewById(R.id.title);
		mainLayout = (ViewGroup) findViewById(R.id.main);
		positiveBtn = (Button) findViewById(R.id.positiveBtn);
		negativeBtn = (Button) findViewById(R.id.negativeBtn);
		positiveLayout = (ViewGroup) findViewById(R.id.positiveLayout);
		negativeLayout = (ViewGroup) findViewById(R.id.negativeLayout);
		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout);
		
	}
		
	protected void initComponent(){
		initWindowAttributes();
		if(dialogData.getBg() != null) mainLayout.setBackgroundResource(dialogData.getBg());
		if(dialogData.getPadding() != null) mainLayout.setPadding(dialogData.getPadding(), dialogData.getPadding(), dialogData.getPadding(), dialogData.getPadding());
		
		if(dialogData.getTitle() != null) titleTV.setText(dialogData.getTitle()); else titleTV.setVisibility(View.GONE);
		if(dialogData.getTitleTextAppearance() != null) titleTV.setTextAppearance(context, dialogData.getTitleTextAppearance());
		if(dialogData.getTitleTextColor() != null) titleTV.setTextColor(dialogData.getTitleTextColor());
		if(dialogData.getTitleTextSize() != null) titleTV.setTextSize(dialogData.getTitleTextSize());
		if(dialogData.getTitleBackground() != null) titleTV.setBackgroundResource(dialogData.getTitleBackground());
		
		if(dialogData.isShowPositiveBtn() == false) positiveBtn.setVisibility(View.GONE);
		if(dialogData.getPositiveBtnText() != null) positiveBtn.setText(dialogData.getPositiveBtnText());
		if(dialogData.getPositiveBtnBg() != null) positiveBtn.setBackgroundResource(dialogData.getPositiveBtnBg());
		positiveBtn.setOnClickListener(onPositiveClick);
		if(dialogData.isShowNegativeBtn() == false) negativeBtn.setVisibility(View.GONE);
		if(dialogData.getNegativeBtnText() != null) negativeBtn.setText(dialogData.getNegativeBtnText());
		if(dialogData.getNegativeBtnBg() != null) negativeBtn.setBackgroundResource(dialogData.getNegativeBtnBg());
		negativeBtn.setOnClickListener(onNegativeClick);
		
		if(dialogData.getButtonPadding() != null) setButtonPadding(dialogData.getButtonPadding());
		if(dialogData.getButtonMargin() != null) setButtonMargin(dialogData.getButtonMargin());
		if(dialogData.getButtonTextAppearance() != null) setButtonTextAppearance(dialogData.getButtonTextAppearance());
		if(dialogData.isShowButtons() == false) buttonLayout.setVisibility(View.GONE);
		
		
	}
	private void setButtonTextAppearance(int resId){
		positiveBtn.setTextAppearance(context, resId);
		negativeBtn.setTextAppearance(context, resId);
	}
	
	private void setButtonPadding(int padding){
		positiveBtn.setPadding(padding, padding, padding, padding);
		negativeBtn.setPadding(padding, padding, padding, padding);
	}
	private void setButtonMargin(int margin){
		positiveLayout.setPadding(margin, margin, margin, margin);
		negativeLayout.setPadding(margin, margin, margin, margin);
	}
	
	private void setTypeView(){
		baseView = (ViewGroup) findViewById(R.id.baseView);
		if(dialogData.getView() != null){
			baseView.addView(dialogData.getView());
		}else{
			if(type != DConstants.DEF_NO_VALUE.NO_INT){
				int viewResId = 0;
				switch(type){
				case DConstants.DEF_DIALOG_TYPE.ALERT_DIALOG:
					viewResId = R.layout.display_alert;
					break;
				case DConstants.DEF_DIALOG_TYPE.LIST_DIALOG:
					viewResId = R.layout.display_list;
					break;
				}
				View view = LayoutInflater.from(context).inflate(viewResId, null);
				baseView.addView(view);
			}
		}
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
        if(dialogData.getWidthFraction() != null) lp.width = (int)(dialogData.getWidthFraction() * getFullWindowsWH()[0]);
        if(dialogData.getHeightFraction() != null) lp.height = (int)(dialogData.getHeightFraction() * getFullWindowsWH()[1]);
        System.out.println(lp.width);
        dialogWindow.setAttributes(lp);
        
        if(dialogData.getAnim() != null) dialogWindow.setWindowAnimations(dialogData.getAnim()); 
	}
	
	private int[] getFullWindowsWH(){
		DisplayMetrics dm = new DisplayMetrics();
    	((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
    	int dispWidth = dm.widthPixels;
    	int dispHeight = dm.widthPixels;
    	Log.d("Full ScreenW = ", dispWidth + "");
    	Log.d("Full ScreenH = ", dispHeight + "");
    	int[] result = {dispWidth, dispHeight};
    	return result;
	}
	
	
	
	private View.OnClickListener onPositiveClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if(dialogData.getOnPositiveClickListener() != null) dialogData.getOnPositiveClickListener().onClick(v);
			autoDismiss();
		}

	};
	private View.OnClickListener onNegativeClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if(dialogData.getOnNegativeClickListener() != null) dialogData.getOnNegativeClickListener().onClick(v);
			autoDismiss();
		}

	};
	
	protected void autoDismiss(){
		if(dialogData.isAutoDismiss()){
			dismiss();
		}
	}
	
	
	
	// 外部接口
	@Override
	public void setTitle(String title){
		dialogData.setTitle(title);
	}
	
	@Override
	public void setTitle(int resId) {
		String title = context.getString(resId);
		dialogData.setTitle(title);
	}

	@Override
	public void setOnPositiveClickListener(android.view.View.OnClickListener onClick){
		dialogData.setOnPositiveClickListener(onClick);
	}
	@Override
	public void setOnNegativeClickListener(android.view.View.OnClickListener onClick){
		dialogData.setOnNegativeClickListener(onClick);
	}	
	
	@Override
	public void setView(View view) {
		dialogData.setView(view);
	}
	
	// List
	@Override
	public void setOnListItemClickListener(OnListItemClickListener listener){
		
	}
	@Override
	public void setData(List<Object> list){
		
	}
	
	// alert
	@Override
	public void setContent(String content){
		
	}
	
	@Override
	public void setContent(int contentRes) {
		
	}
	
	
	
	//------------create----------------
	
	private static int getType(Context context, int style){
		
		// 无配置信息时的默认值
		final int noInt = DConstants.DEF_NO_VALUE.NO_INT;
		//---------------------读取保存共有属性开始-----------------------
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, attrs);
		// 对话框类别
		type = commonTypedArray.getInteger(R.styleable.CommonDialog_type, noInt);
		commonTypedArray.recycle();
		
		return type;
	}
	
	public static DisplayDialog create(Context context, int style){
		switch(getType(context, style)){
		case DConstants.DEF_DIALOG_TYPE.ALERT_DIALOG:
			return new DisplayAlert(context, style);
		case DConstants.DEF_DIALOG_TYPE.LIST_DIALOG:
			return new DisplayList(context, style);
		default:
			break;
		}
		return new DisplayDialog(context);
	}

	public static int type;
}
