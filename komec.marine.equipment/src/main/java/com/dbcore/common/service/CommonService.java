package com.dbcore.common.service;

import com.dbcore.model.FileInfoVO;

public interface CommonService {
	
	public FileInfoVO getFileDownloadInfo(String param) throws Exception;
	
}
