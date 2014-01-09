package me.risky.commondialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;

public class CommonDialog {
	
	public CommonDialog(){
		
	}
	
	public static Dialog createDialog(Context c, String type){
		if(type.equals("list")){
			return new CommonListDialog(c);
		}else if(type.equals("alert")){
			return null;
		}else{
			return null;
		}
	}
	
	public static Dialog createDialog(Context c, int style){
		//init style value
		TypedArray typedArray = c.obtainStyledAttributes(style, R.styleable.Dialog);
		String type = typedArray.getString(R.styleable.Dialog_type); 
		typedArray.recycle();
		
		if(type.equals("list")){
			return new CommonListDialog(c);
		}else if(type.equals("alert")){
			return null; 
		}else{
			return null;
		}
		
	}
	
}
