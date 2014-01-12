package me.risky.commondialog;

import java.util.List;

import me.risky.commondialog.list.ListViewAdapter.OnListItemClickListener;

public interface IDialog {
	public void setTitle(String title);
	public void setOnPositiveClickListener(android.view.View.OnClickListener onClick);
	public void setOnNegativeClickListener(android.view.View.OnClickListener onClick);
	
	// list
	public void setOnListItemClickListener(OnListItemClickListener listener);
	public void setData(List<Object> list);
	
	// alert
	public void setContent(String content);
}
