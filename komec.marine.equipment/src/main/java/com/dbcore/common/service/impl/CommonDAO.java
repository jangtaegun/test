package com.dbcore.common.service.impl;

import org.springframework.stereotype.Repository;

import com.dbcore.model.FileInfoVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("commonDAO")
public class CommonDAO extends EgovAbstractDAO {
	public FileInfoVO getFileDownloadInfo(String param) throws Exception {
    	return (FileInfoVO)selectByPk("commonDAO.fileAction", param);
    }
}
