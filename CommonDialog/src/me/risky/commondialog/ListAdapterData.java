package me.risky.commondialog;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * list数据和属性包装类
 * 
 * @author chenupt@gmail.com
 * 
 * @version 1.0
 *
 */
public class ListAdapterData {
	private List<Object> list;
	private Integer itemView;
	private boolean isMap;
	private Integer textColor;
	private Float textSize;
	private Integer itemBg;
	private Integer appearance;
	
	public ListAdapterData() {
		// 需实例化
		list = new ArrayList<Object>();
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Integer getItemView() {
		return itemView;
	}
	public void setItemView(Integer itemView) {
		this.itemView = itemView;
	}
	public boolean isMap() {
		return isMap;
	}
	public void setMap(boolean isMap) {
		this.isMap = isMap;
	}
	public Integer getTextColor() {
		return textColor;
	}
	public void setTextColor(Integer textColor) {
		this.textColor = textColor;
	}
	public Float getTextSize() {
		return textSize;
	}
	public void setTextSize(Float textSize) {
		this.textSize = textSize;
	}
	public Integer getItemBg() {
		return itemBg;
	}
	public void setItemBg(Integer itemBg) {
		this.itemBg = itemBg;
	}
	public Integer getAppearance() {
		return appearance;
	}
	public void setAppearance(Integer appearance) {
		this.appearance = appearance;
	}
}
