package com.dbcore.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dbcore.code.service.CodeService;
import com.dbcore.code.service.ICodeDAO;
import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

//@Service("codeService")
public class CodeServiceImpl implements CodeService{
	
	//@Resource(name="codeDAO")
	private ICodeDAO codeDAO;
	
	public void setCodeDAO(CodeDAO codeDAO) {
		this.codeDAO = codeDAO;
	}

	@Override
	public List<Object> selectList(CodeVO vo) throws Exception {
		return codeDAO.selectList(vo);
	}	

	@Override
	public List<Object> selectSoCodeList(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectSoCodeList(vo);
	}

	@Override
	public int getTotalCount(CodeVO vo) throws Exception {
		return codeDAO.getTotalCount(vo);
	}
	
	@Override
	public int getSoCodeTotalCount(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.getSoCodeTotalCount(vo);
	}

	@Override
	public CodeVO detailView(CodeVO vo) throws Exception {
		return codeDAO.detailView(vo);
	}

	@Override
	public CodeVO detailSoCdedView(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.detailSoCodeView(vo);
	}

	@Override
	public void insert(CodeVO vo) throws Exception {
		codeDAO.insert(vo);
	}
	
	
	
	@Override
	public void insertSoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.insertSoCode(vo);
		
	}

	@Override
	public void modifySoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.modifySoCode(vo);
	}

	@Override
	public void modify(CodeVO vo) throws Exception {
		codeDAO.modify(vo);
	}

	@Override
	public void delete(CodeVO vo) throws Exception {
		codeDAO.delete(vo);
	}

	@Override
	public void deleteSoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.deleteSoCode(vo);
	}

	@Override
	public List<Object> selectComboItems(CommonCodeParm codeParm)
			throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectComboItems(codeParm);
	}

	@Override
	public List<Object> selectSoCodeComboItems(CommonCodeParm codeParm)
			throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectSoCodeComboItems(codeParm);
	}
	
	
	
}
