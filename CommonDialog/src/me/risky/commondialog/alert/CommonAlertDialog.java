package me.risky.commondialog.alert;

import me.risky.commondialog.CDConstants;
import me.risky.commondialog.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CommonAlertDialog extends Dialog{
	
	private Context context;
	private DialogData dialogData;
	private TextView titleTV;
	private TextView contentTV;
	private ViewGroup mainLayout;
	private Button positiveBtn;
	private Button negativeBtn;
	private ViewGroup positiveLayout;
	private ViewGroup negativeLayout;

	public CommonAlertDialog(Context context){
		super(context, R.style.Theme_CommonAlertDialog);
		this.context = context;
		initData(R.style.Theme_CommonAlertDialog);
	}
	
	public CommonAlertDialog(Context context, int style){
		super(context, style);
		this.context = context;
		initData(style);
	}
	
	public CommonAlertDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}
	
	private void initData(){
		dialogData = new DialogData();
	}
	
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
		final int noBg = CDConstants.DEF_NO_VALUE.NO_BG;
		final float noFloat = CDConstants.DEF_NO_VALUE.NO_FLOAT;
		
		// 读取公共的属性
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, R.styleable.CommonDialog);
		int customBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_background, noBg);
		int customX = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_x, noX);
		int customY = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_y, noY);
		int customWidth = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_width, noWidth);
		int customHeight = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_height, noHeight);
		int customGravity = commonTypedArray.getInteger(R.styleable.CommonDialog_android_gravity, noGravity);
		int customAnim = commonTypedArray.getResourceId(R.styleable.CommonDialog_anim, noAnim);
		boolean customAutoDismiss = commonTypedArray.getBoolean(R.styleable.CommonDialog_autoDismiss, true);
		commonTypedArray.recycle();
		
		// 读取私有属性
		TypedArray typedArray = context.obtainStyledAttributes(style, R.styleable.AlertDialog);
		// Title
		int customTitleTextColor = typedArray.getColor(R.styleable.AlertDialog_titleTextColor, noTextColor); 
		float customTitleTextSize = typedArray.getDimension(R.styleable.AlertDialog_titleTextSize, noTextSize); 
		String customTitle = typedArray.getString(R.styleable.AlertDialog_title);
		int customTitleBg = typedArray.getResourceId(R.styleable.AlertDialog_titleBackground, noBg);

		// Content
		int customContentTextColor = typedArray.getColor(R.styleable.AlertDialog_contentTextColor, noTextColor); 
		float customContentTextSize = typedArray.getDimension(R.styleable.AlertDialog_contentTextSize, noTextSize); 
		String customContent = typedArray.getString(R.styleable.AlertDialog_content); 
		int customContentBg = typedArray.getResourceId(R.styleable.AlertDialog_contentBackground, noBg);
		
		// Button
		boolean customIsShowPositiveBtn = typedArray.getBoolean(R.styleable.AlertDialog_positiveButton, true);
		String customPositiveBtnText = typedArray.getString(R.styleable.AlertDialog_positiveButtonText);
		int customPositiveBg = typedArray.getResourceId(R.styleable.AlertDialog_positiveButtonBg, noBg);
		boolean customIsShowNegativeBtn = typedArray.getBoolean(R.styleable.AlertDialog_negativeButton, true);
		String customNegativeBtnText = typedArray.getString(R.styleable.AlertDialog_negativeButtonText);
		int customNegativeBg = typedArray.getResourceId(R.styleable.AlertDialog_negativeButtonBg, noBg);
		
		int customButtonPadding = (int)typedArray.getDimension(R.styleable.AlertDialog_buttonPadding, noFloat);
		int customButtonMargin = (int)typedArray.getDimension(R.styleable.AlertDialog_buttonMargin, noFloat);
		
		typedArray.recycle();
		
		 
		
		// ----------------- 保存配置数据 ---------------------
		// Title
		if(customBg != noBg) dialogData.setBg(customBg);
		if(customX != noX) dialogData.setX(customX);	
		if(customY != noY) dialogData.setY(customY);
		if(customWidth != noWidth) dialogData.setWidth(customWidth);
		if(customHeight != noHeight) dialogData.setHeight(customHeight);
		if(customGravity != noGravity) dialogData.setGravity(customGravity);
		if(customAnim != noAnim) dialogData.setAnim(customAnim);
		dialogData.setAutoDismiss(customAutoDismiss);
		
		// Content 
		if(customTitleTextColor != noTextColor) dialogData.setTitleTextColor(customTitleTextColor);
		if(customTitleTextSize != noTextSize) dialogData.setTitleTextSize(customTitleTextSize);
		if(customTitle != null) dialogData.setTitle(customTitle);
		if(customTitleBg != noBg) dialogData.setTitleBackground(customTitleBg);
		if(customContentTextColor != noTextColor) dialogData.setContentTextColor(customContentTextColor);
		if(customContentTextSize != noTextSize) dialogData.setContentTextSize(customContentTextSize);
		if(customContent != null) dialogData.setContent(customContent);
		if(customContentBg != noBg) dialogData.setContentBackground(customContentBg);
		
		// Button
		dialogData.setShowPositiveBtn(customIsShowPositiveBtn);
		if(customPositiveBtnText != null) dialogData.setPositiveBtnText(customPositiveBtnText);
		if(customPositiveBg != noBg) dialogData.setPositiveBtnBg(customPositiveBg);
		dialogData.setShowNegativeBtn(customIsShowNegativeBtn);
		if(customNegativeBtnText != null)dialogData.setNegativeBtnText(customNegativeBtnText);
		if(customNegativeBg != noBg) dialogData.setNegativeBtnBg(customNegativeBg);
		
		if(customButtonPadding != noFloat) dialogData.setButtonPadding(customButtonPadding);
		if(customButtonMargin != noFloat) dialogData.setButtonMargin(customButtonMargin);
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.common_alert_dialog);
		
		findView();
		initComponent();
	}
	
	private void findView(){
		titleTV = (TextView) findViewById(R.id.title);
		contentTV = (TextView) findViewById(R.id.content);
		mainLayout = (ViewGroup) findViewById(R.id.main);
		positiveBtn = (Button) findViewById(R.id.positiveBtn);
		negativeBtn = (Button) findViewById(R.id.negativeBtn);
		positiveLayout = (ViewGroup) findViewById(R.id.positiveLayout);
		negativeLayout = (ViewGroup) findViewById(R.id.positiveLayout);
	}
	
	private void initComponent(){
		initWindowAttributes();
		if(dialogData.getBg() != null) mainLayout.setBackgroundResource(dialogData.getBg());
		
		if(dialogData.getTitle() != null) titleTV.setText(dialogData.getTitle()); else titleTV.setVisibility(View.GONE);
		if(dialogData.getTitleTextColor() != null) titleTV.setTextColor(dialogData.getTitleTextColor());
		if(dialogData.getTitleTextSize() != null) titleTV.setTextSize(dialogData.getTitleTextSize());
		if(dialogData.getTitleBackground() != null) titleTV.setBackgroundResource(dialogData.getTitleBackground());
		if(dialogData.getContent() != null) contentTV.setText(dialogData.getContent());
		if(dialogData.getContentTextColor() != null) contentTV.setTextColor(dialogData.getContentTextColor());
		if(dialogData.getContentTextSize() != null) contentTV.setTextSize(dialogData.getContentTextSize());
		if(dialogData.getContentBackground() != null) contentTV.setBackgroundResource(dialogData.getContentBackground());
		
		if(dialogData.isShowPositiveBtn() == false) positiveBtn.setVisibility(View.GONE);
		if(dialogData.getPositiveBtnText() != null) positiveBtn.setText(dialogData.getPositiveBtnText());
		if(dialogData.getPositiveBtnBg() != null) positiveBtn.setBackgroundResource(dialogData.getPositiveBtnBg());
		if(dialogData.getOnPositiveClickListener() != null) positiveBtn.setOnClickListener(onPositiveClick);
		if(dialogData.isShowNegativeBtn() == false) negativeBtn.setVisibility(View.GONE);
		if(dialogData.getNegativeBtnText() != null) negativeBtn.setText(dialogData.getNegativeBtnText());
		if(dialogData.getNegativeBtnBg() != null) negativeBtn.setBackgroundResource(dialogData.getNegativeBtnBg());
		if(dialogData.getOnNegativeClickListener() != null) negativeBtn.setOnClickListener(onNegativeClick);
		
		if(dialogData.getButtonPadding() != null) setButtonPadding(dialogData.getButtonPadding());
		if(dialogData.getButtonMargin() != null) setButtonMargin(dialogData.getButtonMargin());
	}
	
	private void setButtonPadding(int padding){
		positiveBtn.setPadding(padding, padding, padding, padding);
		negativeBtn.setPadding(padding, padding, padding, padding);
	}
	private void setButtonMargin(int margin){
		// TODO Some errors
//		MarginLayoutParams mp = new MarginLayoutParams(positiveBtn.getLayoutParams());
//		mp.setMargins(margin, margin, margin, margin);
//		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mp);
//		
//		positiveBtn.setLayoutParams(layoutParams);
//		negativeBtn.setLayoutParams(layoutParams);
		positiveLayout.setPadding(margin, margin, margin, margin);
		negativeLayout.setPadding(margin, margin, margin, margin);
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
        dialogWindow.setAttributes(lp);
        
        if(dialogData.getAnim() != null) dialogWindow.setWindowAnimations(dialogData.getAnim()); 
	}
	
	
	
	private View.OnClickListener onPositiveClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			dialogData.getOnPositiveClickListener().onClick(v);
			autoDismiss();
		}

	};
	private View.OnClickListener onNegativeClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			dialogData.getOnNegativeClickListener().onClick(v);
			autoDismiss();
		}

	};
	
	private void autoDismiss(){
		if(dialogData.isAutoDismiss()){
			dismiss();
		}
	}
	
	// 外部接口

	public void setTitle(String title){
		dialogData.setTitle(title);
	}
	
	public void setContent(String content){
		dialogData.setContent(content);
	}
	
	public void setOnPositiveClickListener(android.view.View.OnClickListener onClick){
		dialogData.setOnPositiveClickListener(onClick);
	}
	
	public void setOnNegativeClickListener(android.view.View.OnClickListener onClick){
		dialogData.setOnNegativeClickListener(onClick);
	}

}
