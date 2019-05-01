package com.dbcore.common.vo;

import java.io.Serializable;

public class LoginInfoVo implements Serializable {
	
	/**
	 * 공통 로그인 정보
	 */
	private static final long serialVersionUID = 5388527361934187718L;
	private static  String chnlIdInfo; 
	private static  String useInitIdInfo;
	
	public static String getChnlIdInfo() {
		return chnlIdInfo;
	}
	public static void setChnlIdInfo(String chnlIdInfo) {
		LoginInfoVo.chnlIdInfo = chnlIdInfo;
	}
	public static String getUseInitIdInfo() {
		return useInitIdInfo;
	}
	public static void setUseInitIdInfo(String useInitIdInfo) {
		LoginInfoVo.useInitIdInfo = useInitIdInfo;
	}
	
	
	
	
}
