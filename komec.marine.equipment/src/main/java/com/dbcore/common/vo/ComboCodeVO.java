package com.dbcore.common.vo;

import java.io.Serializable;

import com.dbcore.common.vo.CommonPageInfo;

public class ComboCodeVO extends CommonPageInfo implements Serializable {
	
	/**
	 * 콩통코드 DTO
	 */
	private static final long serialVersionUID = 1183603035736531776L;
	private String code;		//코드
	private String codeNm;		//코드명
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
