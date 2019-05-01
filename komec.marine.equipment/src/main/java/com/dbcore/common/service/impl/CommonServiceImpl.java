package com.dbcore.common.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.dbcore.common.service.CommonService;
import com.dbcore.model.FileInfoVO;


@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Resource(name="commonDAO")
    private CommonDAO commonDAO;
	
	public FileInfoVO getFileDownloadInfo(String param) throws Exception {
    	return commonDAO.getFileDownloadInfo(param);
	}
}
