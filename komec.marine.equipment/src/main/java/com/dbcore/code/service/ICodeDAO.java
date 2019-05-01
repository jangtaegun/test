package com.dbcore.code.service;

import java.util.List;

import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

public interface ICodeDAO {
	
	public List<Object> selectList(CodeVO vo) throws Exception; 		//상위코드조회
	public List<Object> selectSoCodeList(CodeVO vo) throws Exception; 	//하위코드조회
	public int getTotalCount(CodeVO vo) throws Exception;				//상위코트 총건수
	public int getSoCodeTotalCount(CodeVO vo) throws Exception; 		//하위코드 총건수
	public CodeVO detailView(CodeVO vo) throws Exception;				//코드 세부정보 조회
	public CodeVO detailSoCodeView(CodeVO vo) throws Exception;			//하위코드 세부정보 조회
	public void insert(CodeVO vo) throws Exception;						//코드저장
	public void insertSoCode(CodeVO vo) throws Exception;				//하위코드저장
	public void modify(CodeVO vo) throws Exception;						//코드변경
	public void modifySoCode(CodeVO vo) throws Exception;				//하위코드변경
	public void delete(CodeVO vo) throws Exception;						//코드삭제
	public void deleteSoCode(CodeVO vo) throws Exception;				//하위코드삭제
	
	
	public List<Object> selectComboItems(CommonCodeParm codeParm)throws Exception;			//콤보코드조회
	public List<Object> selectSoCodeComboItems(CommonCodeParm codeParm)throws Exception;	//콤보하위코드조회

}
