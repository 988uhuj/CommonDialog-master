package me.risky.commondialog;

/**
 * 
 * Dialog数据和属性封装类
 * 
 * @author chenupt@gmail.com
 * 
 * @version 1.0
 *
 */
public class DialogData {
	private boolean showTitle;
	private Integer width;
	private Integer height;
	private Float alpha; 
	private Integer x;
	private Integer y;
	private Integer gravity;
	private Integer bg;
	private boolean showCancelBtn;
	private Integer padding;
	private Float textSize;
	private Integer anim;
	private Integer itemBg;
	private String[] menus;
	private Integer textAppearance;
	public Integer getTextColor() {
		return textColor;
	}
	public void setTextColor(Integer textColor) {
		this.textColor = textColor;
	}
	public void setAlpha(Float alpha) {
		this.alpha = alpha;
	}
	private Integer textColor;
	public boolean isShowTitle() {
		return showTitle;
	}
	public void setShowTitle(boolean showTitle) {
		this.showTitle = showTitle;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Float getAlpha() {
		return alpha;
	}
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getGravity() {
		return gravity;
	}
	public void setGravity(Integer gravity) {
		this.gravity = gravity;
	}
	public boolean isShowCancelBtn() {
		return showCancelBtn;
	}
	public void setShowCancelBtn(boolean showCancelBtn) {
		this.showCancelBtn = showCancelBtn;
	}
	public Integer getPadding() {
		return padding;
	}
	public void setPadding(Integer padding) {
		this.padding = padding;
	}
	public Float getTextSize() {
		return textSize;
	}
	public void setTextSize(Float textSize) {
		this.textSize = textSize;
	}
	public Integer getAnim() {
		return anim;
	}
	public void setAnim(Integer anim) {
		this.anim = anim;
	}
	public Integer getItemBg() {
		return itemBg;
	}
	public void setItemBg(Integer itemBg) {
		this.itemBg = itemBg;
	}
	public String[] getMenus() {
		return menus;
	}
	public void setMenus(String[] menus) {
		this.menus = menus;
	}
	public Integer getTextAppearance() {
		return textAppearance;
	}
	public void setTextAppearance(Integer textAppearance) {
		this.textAppearance = textAppearance;
	}
	public Integer getBg() {
		return bg;
	}
	public void setBg(Integer bg) {
		this.bg = bg;
	}

	
}
