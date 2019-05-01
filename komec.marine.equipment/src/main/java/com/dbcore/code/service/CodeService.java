package com.dbcore.code.service;

import java.util.List;

import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

public interface CodeService {
	
	public List<Object> selectList(CodeVO vo) throws Exception;	
	
	public List<Object> selectSoCodeList(CodeVO vo) throws Exception;	
	
	public int getTotalCount(CodeVO vo) throws Exception;
	
	public int getSoCodeTotalCount(CodeVO vo) throws Exception;
	
	public CodeVO detailView(CodeVO vo) throws Exception;

	public CodeVO detailSoCdedView(CodeVO vo) throws Exception;
	
	public void insert(CodeVO vo) throws Exception;
	
	public void insertSoCode(CodeVO vo) throws Exception;
	
	public void delete(CodeVO vo) throws Exception;
	
	public void deleteSoCode(CodeVO vo) throws Exception;
	
	public void modify(CodeVO vo) throws Exception;
	
	public void modifySoCode(CodeVO vo)throws Exception;
	
	public List<Object> selectComboItems(CommonCodeParm commonCodeParm) throws Exception;
	
	public List<Object> selectSoCodeComboItems(CommonCodeParm commonCodeParm) throws Exception;
}
