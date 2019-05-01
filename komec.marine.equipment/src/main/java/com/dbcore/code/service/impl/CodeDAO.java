package com.dbcore.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbcore.code.service.ICodeDAO;
import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

//@Repository("codeDAO")
public class CodeDAO extends EgovAbstractDAO implements ICodeDAO {
	
	public List<Object> selectList(CodeVO vo) throws Exception {
    	return list("codeDAO.selectList", vo);
    }
	
	@Override
	public List<Object> selectSoCodeList(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return list("codeDAO.selectSoCodeList", vo);
	}

	public int getTotalCount(CodeVO vo) throws Exception {
		return  (Integer)getSqlMapClientTemplate().queryForObject("codeDAO.getTotalCount", vo);
	}
	
	
	@Override
	public int getSoCodeTotalCount(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return  (Integer)getSqlMapClientTemplate().queryForObject("codeDAO.getSoCodeTotalCount", vo);
	}

	public CodeVO detailView(CodeVO vo) throws Exception {
		return (CodeVO) selectByPk("codeDAO.selectDetailView", vo);
	}
	
	@Override
	public CodeVO detailSoCodeView(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (CodeVO) selectByPk("code.detailSoCodeView", vo);
	}

	public void insert(CodeVO vo) throws Exception{
		insert("codeDAO.insert", vo);
	}
	
	@Override
	public void insertSoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		insert("code.insertSoCode", vo);
		
	}

	public void modify(CodeVO vo) throws Exception{
		update("codeDAO.modify", vo);
	}
	
	@Override
	public void modifySoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		update("code.modifySoCode", vo);
		
	}

	public void delete(CodeVO vo) throws Exception{
		delete("codeDAO.delete", vo);
	}

	@Override
	public void deleteSoCode(CodeVO vo) throws Exception {
		// TODO Auto-generated method stub
		delete("code.deleteSoCode", vo);
		
	}

	@Override
	public List<Object> selectComboItems(CommonCodeParm  codeParm) throws Exception {
		// TODO Auto-generated method stub
		return list("comboCodeMap.selectComboItems", codeParm);
	}

	@Override
	public List<Object> selectSoCodeComboItems(CommonCodeParm codeParm)
			throws Exception {
		// TODO Auto-generated method stub
		return list("comboCodeMap.selectSoCodeComboItems", codeParm);
	}
	
	
	
	
}
