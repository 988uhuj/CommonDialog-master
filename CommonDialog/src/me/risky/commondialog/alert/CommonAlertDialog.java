package me.risky.commondialog.alert;

import me.risky.commondialog.CDConstants;
import me.risky.commondialog.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.TextView;

public class CommonAlertDialog extends BaseDialog{
	
	private TextView contentTV;
	private static final int[] attrs = R.styleable.AlertDialog;

	public CommonAlertDialog(Context context){
		super(context, R.style.Theme_CommonAlertDialog);
	}
	
	public CommonAlertDialog(Context context, int style){
		super(context, style);
	}
	
	@Override
	protected void initData(int style){
		super.initData(style);
		//---------------------读取保存共有属性结束-----------------------
		// 无配置信息时的默认值
		final float noFloat = CDConstants.DEF_NO_VALUE.NO_FLOAT;
		final int noInt = CDConstants.DEF_NO_VALUE.NO_INT;
		
		// 读取私有属性
		TypedArray typedArray = context.obtainStyledAttributes(style, attrs);
		// Content
		int customContentTextColor = typedArray.getColor(R.styleable.AlertDialog_contentTextColor, noInt); 
		float customContentTextSize = typedArray.getDimension(R.styleable.AlertDialog_contentTextSize, noInt); 
		String customContent = typedArray.getString(R.styleable.AlertDialog_content); 
		int customContentBg = typedArray.getResourceId(R.styleable.AlertDialog_contentBackground, noInt);
		typedArray.recycle();
		
		// ----------------- 保存配置数据 ---------------------
		
		// Save content 
		if(customContentTextColor != noFloat) dialogData.setContentTextColor(customContentTextColor);
		if(customContentTextSize != noInt) dialogData.setContentTextSize(customContentTextSize);
		if(customContent != null) dialogData.setContent(customContent);
		if(customContentBg != noInt) dialogData.setContentBackground(customContentBg);
		
	}
	
	
	@Override
	protected void findView(){
		super.findView();
		contentTV = (TextView) findViewById(R.id.content);
	}
	
	@Override
	protected void initComponent() {
		super.initComponent();
		
		if(dialogData.getContent() != null) contentTV.setText(dialogData.getContent());
		if(dialogData.getContentTextColor() != null) contentTV.setTextColor(dialogData.getContentTextColor());
		if(dialogData.getContentTextSize() != null) contentTV.setTextSize(dialogData.getContentTextSize());
		if(dialogData.getContentBackground() != null) contentTV.setBackgroundResource(dialogData.getContentBackground());
	}

	
}
