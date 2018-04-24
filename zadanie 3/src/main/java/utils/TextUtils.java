package utils;

public class TextUtils {
	
	private TextUtils() {
		
	}
	
	public static final boolean isEmpty(String text) {
		return text == null || text.length() == 0;
	}
}
