package com.dbcore.parm.common;

import com.dbcore.common.vo.LoginInfoVo;

public class CommonCodeParm extends LoginInfoVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645404862813420642L;
	private String codeType;
	private String code;
	private String codeNm;
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
}
