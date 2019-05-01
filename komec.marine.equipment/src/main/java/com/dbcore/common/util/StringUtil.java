package com.dbcore.common.util;

import java.io.UnsupportedEncodingException;

import com.dbcore.common.ProjectConstant;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) return true;
		return false;
	}

	public static String isEmpty(String str, String val) {
		if(str == null || "".equals(str.trim())) return val;
		return str;
	}

	public static boolean isNull(Object str) {
		if(str == null) return true;
		return false;
	}

	public static String isNull(String str) {
		if(str == null) return "";
		return str;
	}

	public static String isNull(String str, String val) {
		if(str == null) return val;
		return str;
	}

	public static int isNull(Integer intValue) {
		if(intValue == null) return 0;
		return intValue.intValue();
	}

	public static int isNull(Integer intValue, int val) {
		if(intValue == null) return val;
		return intValue.intValue();
	}


	public static int strToInt(String str) {
		if(str == null || "".equals(str)) return 0;
		return Integer.parseInt(str);
	}

	public static int strToInt(String str, int val) {
		if(str == null || "".equals(str)) return 0;
		return val;
	}

	public static String intToStr(int value) {
		return String.valueOf(value);
	}

	public static String encoding(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes(ProjectConstant.ENCODING_SERVER), ProjectConstant.ENCODING_PAGE);
	}

	public static String decoding(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes(ProjectConstant.ENCODING_PAGE), ProjectConstant.ENCODING_SERVER);
	}
	
	public static String removeSpecialFileChar(String str){
	    String str_imsi   = "";
	    String[] filter_word = {"","\\?","\\/","\\~","\\!","\\@","\\#","\\$","\\%","\\^","\\&","\\*","\\+","\\=","\\|","\\\\","\\\"","\\'","\\:","\\;","\\<","\\,","\\>"};
	    for(int i=0;i<filter_word.length;i++){
	        str_imsi = str.replaceAll(filter_word[i],"");
	        str = str_imsi;
	    }
	    return str;
	}
}
