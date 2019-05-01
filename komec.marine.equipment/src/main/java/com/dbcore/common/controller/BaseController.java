package com.dbcore.common.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class BaseController {
	
	protected Map<String, Object> paramMap;
	protected final Logger logger = Logger.getLogger(getClass());
	
	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public Map<String, Object> getParamMap() {
		return paramMap;
	}
	
	public void clearParamMap() {
		if(paramMap != null) {
			clearHashMap(paramMap);
		}
	}
	
	private void clearHashMap(Map data) {
		Iterator itr = data.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry value = (Map.Entry) itr.next();
			if(value.getValue() instanceof List) {
				List mapList = (List) value.getValue();
				for(int i=0; i < mapList.size(); i++ ) {
					if(mapList.get(i) instanceof Map) {
						Map map = (Map) mapList.get(i);
						clearHashMap(map);
					}
				}
			} else {
				data.remove(value);
			}
		}  
		data.clear();
		data = null;
	}
	
	public PaginationInfo painationSetting(int currentPageNo, int recordCountPerPage, int pageSize,int totalCount) {
		//PaginationInfo에 필수 정보를 넣어 준다.
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); //현재페이지번호
		paginationInfo.setRecordCountPerPage(recordCountPerPage); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(pageSize); //페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalCount); 
		
		return paginationInfo;
	}
	
}
