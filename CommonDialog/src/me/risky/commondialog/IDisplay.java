package me.risky.commondialog;

import java.util.List;

import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;
import android.view.View;

public interface IDisplay {
	public void setTitle(String title);
	public void setTitle(int resId);
	
	public void setOnPositiveClickListener(android.view.View.OnClickListener onClick);
	public void setOnNegativeClickListener(android.view.View.OnClickListener onClick);
	
	public void setView(View view);
	
	// list
	public void setOnListItemClickListener(OnListItemClickListener listener);
	public void setData(List<Object> list);
	
	// alert
	public void setContent(String content);
	public void setContent(int resId);
	
}
