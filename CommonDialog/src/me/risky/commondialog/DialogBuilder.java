package me.risky.commondialog;

import me.risky.commondialog.alert.CommonAlertDialog;
import android.content.Context;
import android.content.res.TypedArray;

public class DialogBuilder {
	
	private static final int style = R.style.Theme_CommonAlertDialog;
	private static final int[] attrs = R.styleable.CommonDialog;
	
	private static int init(Context context){
		// 无配置信息时的默认值
		final int noInt = CDConstants.DEF_NO_VALUE.NO_INT;
		//---------------------读取保存共有属性开始-----------------------
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, attrs);
		// 对话框类别
		int customType = commonTypedArray.getInteger(R.styleable.CommonDialog_type, noInt);
		commonTypedArray.recycle();
		
		return customType;
	}
	
	public static void create(Context context){
		switch(init(context)){
		case CDConstants.DEF_DIALOG_TYPE.ALERT_DIALOG:
			break;
		case CDConstants.DEF_DIALOG_TYPE.LIST_DIALOG:
			new CommonAlertDialog(context);
			break;
		default:
			break;
		}
	}
}
