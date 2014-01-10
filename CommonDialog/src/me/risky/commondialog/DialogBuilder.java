package me.risky.commondialog;

import me.risky.commondialog.alert.CommonAlertDialog;
import android.content.Context;
import android.content.res.TypedArray;

public class DialogBuilder {
	
	private static final int style = R.style.Theme_CommonAlertDialog;
	private static final int[] attrs = R.styleable.CommonDialog;
	
	private static int init(Context context){
		// ��������Ϣʱ��Ĭ��ֵ
		final int noInt = CDConstants.DEF_NO_VALUE.NO_INT;
		//---------------------��ȡ���湲�����Կ�ʼ-----------------------
		
		TypedArray commonTypedArray = context.obtainStyledAttributes(style, attrs);
		// �Ի������
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
