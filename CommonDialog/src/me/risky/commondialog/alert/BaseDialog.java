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
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseDialog extends Dialog{
	
	protected Context context;
	protected DialogData dialogData;
	private TextView titleTV;
	
	private ViewGroup mainLayout;
	private Button positiveBtn;
	private Button negativeBtn;
	private ViewGroup positiveLayout;
	private ViewGroup negativeLayout;
	private LinearLayout buttonLayout;
	
	private static final int style = R.style.Theme_CommonAlertDialog;
	private static final int[] attrs = R.styleable.CommonDialog;

	public BaseDialog(Context context) {
		super(context, style);
		this.context = context;
		
		initData(style);
	}
	
	public BaseDialog(Context context, int style){
		super(context, style);
		this.context = context;
		
		initData(style);
	}
	
	
	protected void initData(){
		dialogData = new DialogData();
	}
	
	protected void initData(int style){
		initData();
		// ��������Ϣʱ��Ĭ��ֵ
		final int noInt = CDConstants.DEF_NO_VALUE.NO_INT;
		final float noFloat = CDConstants.DEF_NO_VALUE.NO_FLOAT;
		
		//---------------------��ȡ���湲�����Կ�ʼ-----------------------
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, attrs);
		// �Ի������
		int customType = commonTypedArray.getInteger(R.styleable.CommonDialog_type, noInt);
		// Window
		int customBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_background, noInt);
		int customX = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_x, noInt);
		int customY = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_y, noInt);
		int customWidth = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_width, noInt);
		int customHeight = (int) commonTypedArray.getDimension(R.styleable.CommonDialog_height, noInt);
		int customGravity = commonTypedArray.getInteger(R.styleable.CommonDialog_android_gravity, noInt);
		int customAnim = commonTypedArray.getResourceId(R.styleable.CommonDialog_anim, noInt);
		boolean customAutoDismiss = commonTypedArray.getBoolean(R.styleable.CommonDialog_autoDismiss, true);
		boolean customShowButtons = commonTypedArray.getBoolean(R.styleable.CommonDialog_showButtons, true);
		
		// Title
		int customTitleTextColor = commonTypedArray.getColor(R.styleable.CommonDialog_titleTextColor, noInt); 
		float customTitleTextSize = commonTypedArray.getDimension(R.styleable.CommonDialog_titleTextSize, noInt); 
		String customTitle = commonTypedArray.getString(R.styleable.CommonDialog_title);
		int customTitleBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_titleBackground, noInt);

		// Button
		boolean customIsShowPositiveBtn = commonTypedArray.getBoolean(R.styleable.CommonDialog_positiveButton, true);
		String customPositiveBtnText = commonTypedArray.getString(R.styleable.CommonDialog_positiveButtonText);
		int customPositiveBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_positiveButtonBg, noInt);
		boolean customIsShowNegativeBtn = commonTypedArray.getBoolean(R.styleable.CommonDialog_negativeButton, true);
		String customNegativeBtnText = commonTypedArray.getString(R.styleable.CommonDialog_negativeButtonText);
		int customNegativeBg = commonTypedArray.getResourceId(R.styleable.CommonDialog_negativeButtonBg, noInt);
		
		int customButtonPadding = (int)commonTypedArray.getDimension(R.styleable.CommonDialog_buttonPadding, noFloat);
		int customButtonMargin = (int)commonTypedArray.getDimension(R.styleable.CommonDialog_buttonMargin, noFloat);
		commonTypedArray.recycle();
		
		
		// ������������ 
		if(customType != noInt) dialogData.setType(customType);
		// save Window
		if(customBg != noInt) dialogData.setBg(customBg);
		if(customX != noInt) dialogData.setX(customX);	
		if(customY != noInt) dialogData.setY(customY);
		if(customWidth != noInt) dialogData.setWidth(customWidth);
		if(customHeight != noInt) dialogData.setHeight(customHeight);
		if(customGravity != noInt) dialogData.setGravity(customGravity);
		if(customAnim != noInt) dialogData.setAnim(customAnim);
		dialogData.setAutoDismiss(customAutoDismiss);
		dialogData.setShowButtons(customShowButtons);
		
		// Save title
		if(customTitleTextColor != noFloat) dialogData.setTitleTextColor(customTitleTextColor);
		if(customTitleTextSize != noInt) dialogData.setTitleTextSize(customTitleTextSize);
		if(customTitle != null) dialogData.setTitle(customTitle);
		if(customTitleBg != noInt) dialogData.setTitleBackground(customTitleBg);
		
		// Save button
		dialogData.setShowPositiveBtn(customIsShowPositiveBtn);
		if(customPositiveBtnText != null) dialogData.setPositiveBtnText(customPositiveBtnText);
		if(customPositiveBg != noInt) dialogData.setPositiveBtnBg(customPositiveBg);
		dialogData.setShowNegativeBtn(customIsShowNegativeBtn);
		if(customNegativeBtnText != null)dialogData.setNegativeBtnText(customNegativeBtnText);
		if(customNegativeBg != noInt) dialogData.setNegativeBtnBg(customNegativeBg);
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
	
	protected void findView(){
		// ���еĿؼ�
		titleTV = (TextView) findViewById(R.id.title);
		mainLayout = (ViewGroup) findViewById(R.id.main);
		positiveBtn = (Button) findViewById(R.id.positiveBtn);
		negativeBtn = (Button) findViewById(R.id.negativeBtn);
		positiveLayout = (ViewGroup) findViewById(R.id.positiveLayout);
		negativeLayout = (ViewGroup) findViewById(R.id.negativeLayout);
		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout);
		
		switch(dialogData.getType()){
		case CDConstants.DEF_DIALOG_TYPE.LIST_DIALOG:
//			findListView();
			break;
		case CDConstants.DEF_DIALOG_TYPE.ALERT_DIALOG:
//			findAlertView();
			break;
		default:
			break;
		}
	}
		
	protected void initComponent(){
		initWindowAttributes();
		if(dialogData.getBg() != null) mainLayout.setBackgroundResource(dialogData.getBg());
		
		if(dialogData.getTitle() != null) titleTV.setText(dialogData.getTitle()); else titleTV.setVisibility(View.GONE);
		if(dialogData.getTitleTextColor() != null) titleTV.setTextColor(dialogData.getTitleTextColor());
		if(dialogData.getTitleTextSize() != null) titleTV.setTextSize(dialogData.getTitleTextSize());
		if(dialogData.getTitleBackground() != null) titleTV.setBackgroundResource(dialogData.getTitleBackground());
		
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
		if(dialogData.isShowButtons() == false) buttonLayout.setVisibility(View.GONE);
		
		switch(dialogData.getType()){
		case CDConstants.DEF_DIALOG_TYPE.LIST_DIALOG:
			
			break;
		case CDConstants.DEF_DIALOG_TYPE.ALERT_DIALOG:
			break;
		default:
			break;
		}
		
		
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
	 * ����dialog��������
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
	
	// �ⲿ�ӿ�

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