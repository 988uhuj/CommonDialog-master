package me.risky.commondialog;

public class DConstants {
	
	public final static int DEFAULT_THEME_LIST = R.style.CommonListDialog;
	public final static int DEFAULT_THEME_LIST_SPACE = R.style.CommonSpaceListDialog;
	public final static int DEFAULT_THEME_ALERT = R.style.CommonAlertDialog;
	public final static int DEFAULT_EMTPY = R.style.BaseEmptyDialog;
	
	/**
	 * 定义Map数据源的key值
	 *
	 */
	public static class DEF_MAP_KEY{
		public static String BTN_TEXT_COLOR = "btn_color";
		public static String BTN_TEXT = "btn_text";
		public static String BTN_TEXT_SIZE = "btn_text_size";
		public static String BTN_PADDING = "btn_padding";
		public static String BTN_BG = "btn_bg";
		public static String BTN_DRAWABLE_PADDING = "btndrawable_padding";
		public static String BTN_DRAWABLE = "btn_drawable";
	}
	
	 
	/**
	 * 定义读取配置文件时的默认值
	 *
	 */
	public static class DEF_NO_VALUE{
		public static int NO_INT = -1;
		public static float NO_FLOAT = -1.0f;
	}
	
	public static class DEF_DIALOG_TYPE{
		public final static int LIST_DIALOG = 1;
		public final static int ALERT_DIALOG = 2;
	}
}
