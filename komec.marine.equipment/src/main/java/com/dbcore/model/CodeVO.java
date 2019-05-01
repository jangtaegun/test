package com.dbcore.model;

import com.dbcore.common.vo.CommonPageInfo;

public class CodeVO extends CommonPageInfo {
	
	//페이징을 위한 변수 설정
	private String seq;	
	private String chnlId;
	private String useInitId;
	private String cmmnGbCd;
	private String cmmnCd;
	private String cmmnGbNm;
	private String cmmnCdNm;
	private String number1Dc;
	private String number2Dc;
	private String number3Dc;
	private String chrctr1Dc;
	private String chrctr2Dc;
	private String chrctr3Dc;
	private String sortOrdr;
	private String rm;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	public String getChnlId() {
		return chnlId;
	}
	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}
	public String getUseInitId() {
		return useInitId;
	}
	public void setUseInitId(String useInitId) {
		this.useInitId = useInitId;
	}
	public String getCmmnGbCd() {
		return cmmnGbCd;
	}
	public void setCmmnGbCd(String cmmnGbCd) {
		this.cmmnGbCd = cmmnGbCd;
	}
	public String getCmmnGbNm() {
		return cmmnGbNm;
	}
	public void setCmmnGbNm(String cmmnGbNm) {
		this.cmmnGbNm = cmmnGbNm;
	}
	public String getNumber1Dc() {
		return number1Dc;
	}
	public void setNumber1Dc(String number1Dc) {
		this.number1Dc = number1Dc;
	}
	public String getNumber2Dc() {
		return number2Dc;
	}
	public void setNumber2Dc(String number2Dc) {
		this.number2Dc = number2Dc;
	}
	public String getNumber3Dc() {
		return number3Dc;
	}
	public void setNumber3Dc(String number3Dc) {
		this.number3Dc = number3Dc;
	}
	public String getChrctr1Dc() {
		return chrctr1Dc;
	}
	public void setChrctr1Dc(String chrctr1Dc) {
		this.chrctr1Dc = chrctr1Dc;
	}
	public String getChrctr2Dc() {
		return chrctr2Dc;
	}
	public void setChrctr2Dc(String chrctr2Dc) {
		this.chrctr2Dc = chrctr2Dc;
	}
	public String getChrctr3Dc() {
		return chrctr3Dc;
	}
	public void setChrctr3Dc(String chrctr3Dc) {
		this.chrctr3Dc = chrctr3Dc;
	}
	public String getSortOrdr() {
		return sortOrdr;
	}
	public void setSortOrdr(String sortOrdr) {
		this.sortOrdr = sortOrdr;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	
	public String getCmmnCd() {
		return cmmnCd;
	}
	public void setCmmnCd(String cmmnCd) {
		this.cmmnCd = cmmnCd;
	}
	public String getCmmnCdNm() {
		return cmmnCdNm;
	}
	public void setCmmnCdNm(String cmmnCdNm) {
		this.cmmnCdNm = cmmnCdNm;
	}
	@Override
	public String toString() {
		return "CodeVO [chnlId=" + chnlId + ", useInitId=" + useInitId
				+ ", cmmnGbCd=" + cmmnGbCd + ", cmmnGbNm=" + cmmnGbNm
				+ ", number1Dc=" + number1Dc + ", number2Dc=" + number2Dc
				+ ", number3Dc=" + number3Dc + ", chrctr1Dc=" + chrctr1Dc
				+ ", chrctr2Dc=" + chrctr2Dc + ", chrctr3Dc=" + chrctr3Dc
				+ ", sortOrdr=" + sortOrdr + ", rm=" + rm + "]";
	}		
}
