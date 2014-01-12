package me.risky.commondialog;

import android.view.View.OnClickListener;


public class DialogData {
	private Integer width;
	private Integer height;
	private Float widthFraction;
	private Float heightFraction;
	private Float alpha; 
	private Integer x;
	private Integer y;
	private Integer gravity;
	private Integer bg;
	private Integer anim;
	private Integer padding;
	
	private Float titleTextSize;
	private Integer titleTextColor;
	private String title;
	private Integer titleBackground;
	
	private boolean showPositiveBtn;
	private String positiveBtnText;
	private Integer positiveBtnBg;
	private OnClickListener onPositiveClickListener;
	private OnClickListener onNegativeClickListener;
	private boolean showNegativeBtn;
	private String negativeBtnText;
	private Integer negativeBtnBg;
	private Integer buttonPadding;	
	private Integer buttonMargin;
	private boolean autoDismiss; 
	private boolean showButtons;
	
	private Integer type;
	
	
	//------List--------
	
	private Integer listItemBg;
	private String[] listMenus;
	private Integer listTextAppearance;
	private Float listTextSize;
	
	//------Alert------
	
	private Float contentTextSize;
	private Integer contentTextColor;
	private String content;
	private Integer contentBackground;
	private Integer alertContentTextApperance;
		
	
	
	public Integer getListItemBg() {
		return listItemBg;
	}
	public void setListItemBg(Integer listItemBg) {
		this.listItemBg = listItemBg;
	}
	public String[] getListMenus() {
		return listMenus;
	}
	public void setListMenus(String[] listMenus) {
		this.listMenus = listMenus;
	}
	public Integer getListTextAppearance() {
		return listTextAppearance;
	}
	public void setListTextAppearance(Integer listTextAppearance) {
		this.listTextAppearance = listTextAppearance;
	}
	public Float getListTextSize() {
		return listTextSize;
	}
	public void setListTextSize(Float listTextSize) {
		this.listTextSize = listTextSize;
	}
	public Integer getListTextColor() {
		return listTextColor;
	}
	public void setListTextColor(Integer listTextColor) {
		this.listTextColor = listTextColor;
	}
	private Integer listTextColor;
	
	
	
	public Integer getTitleBackground() {
		return titleBackground;
	}
	public void setTitleBackground(Integer titleBackground) {
		this.titleBackground = titleBackground;
	}
	public Integer getContentBackground() {
		return contentBackground;
	}
	public void setContentBackground(Integer contentBackground) {
		this.contentBackground = contentBackground;
	}
	
	public boolean isShowPositiveBtn() {
		return showPositiveBtn;
	}
	public void setShowPositiveBtn(boolean showPositiveBtn) {
		this.showPositiveBtn = showPositiveBtn;
	}
	public String getPositiveBtnText() {
		return positiveBtnText;
	}
	public void setPositiveBtnText(String positiveBtnText) {
		this.positiveBtnText = positiveBtnText;
	}
	public boolean isShowNegativeBtn() {
		return showNegativeBtn;
	}
	public Integer getPositiveBtnBg() {
		return positiveBtnBg;
	}
	public void setPositiveBtnBg(Integer positiveBtnBg) {
		this.positiveBtnBg = positiveBtnBg;
	}
	public Integer getNegativeBtnBg() {
		return negativeBtnBg;
	}
	public void setNegativeBtnBg(Integer negativeBtnBg) {
		this.negativeBtnBg = negativeBtnBg;
	}
	public void setShowNegativeBtn(boolean showNegativeBtn) {
		this.showNegativeBtn = showNegativeBtn;
	}
	public String getNegativeBtnText() {
		return negativeBtnText;
	}
	public void setNegativeBtnText(String negativeBtnText) {
		this.negativeBtnText = negativeBtnText;
	}
	public Float getContentTextSize() {
		return contentTextSize;
	}
	public void setContentTextSize(Float contentTextSize) {
		this.contentTextSize = contentTextSize;
	}
	public Integer getContentTextColor() {
		return contentTextColor;
	}
	public void setContentTextColor(Integer contentTextColor) {
		this.contentTextColor = contentTextColor;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public void setAlpha(Float alpha) {
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
	public Float getTitleTextSize() {
		return titleTextSize;
	}
	public void setTitleTextSize(Float titleTextSize) {
		this.titleTextSize = titleTextSize;
	}
	public Integer getTitleTextColor() {
		return titleTextColor;
	}
	public void setTitleTextColor(Integer titleTextColor) {
		this.titleTextColor = titleTextColor;
	}
	public Integer getAnim() {
		return anim;
	}
	public void setAnim(Integer anim) {
		this.anim = anim;
	}
	public Integer getBg() {
		return bg;
	}
	public void setBg(Integer bg) {
		this.bg = bg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getButtonPadding() {
		return buttonPadding;
	}
	public void setButtonPadding(Integer buttonPadding) {
		this.buttonPadding = buttonPadding;
	}
	public Integer getButtonMargin() {
		return buttonMargin;
	}
	public void setButtonMargin(Integer buttonMargin) {
		this.buttonMargin = buttonMargin;
	}
	public OnClickListener getOnPositiveClickListener() {
		return onPositiveClickListener;
	}
	public void setOnPositiveClickListener(OnClickListener onPositiveClickListener) {
		this.onPositiveClickListener = onPositiveClickListener;
	}
	public OnClickListener getOnNegativeClickListener() {
		return onNegativeClickListener;
	}
	public void setOnNegativeClickListener(OnClickListener onNegativeClickListener) {
		this.onNegativeClickListener = onNegativeClickListener;
	}
	public boolean isAutoDismiss() {
		return autoDismiss;
	}
	public void setAutoDismiss(boolean autoDismiss) {
		this.autoDismiss = autoDismiss;
	}
	public boolean isShowButtons() {
		return showButtons;
	}
	public void setShowButtons(boolean showButtons) {
		this.showButtons = showButtons;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPadding() {
		return padding;
	}
	public void setPadding(Integer padding) {
		this.padding = padding;
	}
	public Float getWidthFraction() {
		return widthFraction;
	}
	public void setWidthFraction(Float widthFraction) {
		this.widthFraction = widthFraction;
	}
	public Float getHeightFraction() {
		return heightFraction;
	}
	public void setHeightFraction(Float heightFraction) {
		this.heightFraction = heightFraction;
	}
	public Integer getAlertContentTextApperance() {
		return alertContentTextApperance;
	}
	public void setAlertContentTextApperance(Integer alertContentTextApperance) {
		this.alertContentTextApperance = alertContentTextApperance;
	}
}
