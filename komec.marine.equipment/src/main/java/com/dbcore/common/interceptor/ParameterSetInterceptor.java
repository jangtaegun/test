package com.dbcore.common.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dbcore.common.ProjectConstant;
import com.dbcore.common.controller.BaseController;
import com.dbcore.common.util.StringUtil;

@org.springframework.stereotype.Controller("parameterSetInterceptor")
public class ParameterSetInterceptor  extends HandlerInterceptorAdapter {

	protected final Log logger = LogFactory.getLog(getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Map<String, String[]> reqMap = request.getParameterMap();

		if(handler instanceof BaseController) {			
			logger.info("-------------- [core intercepter - ParameterSetInterceptor] controller에 파라미터맵(paramMap)을 생성합니다 -----------------");
			
			BaseController controller = (BaseController) handler;
			Map<String, Object> paramMap = new HashMap<String, Object>();

			for(String key : reqMap.keySet()) {
				String[] values = (String[]) reqMap.get(key);
				
				StringBuffer buff = new StringBuffer();
				StringBuffer buffQuote = new StringBuffer();
				
				List multiValueMapList = new ArrayList();
				List multiValueStringList = new ArrayList();
				
				if(values.length == 1) {
					
					String parameterValue = values[0];					
					if("GET".equals(request.getMethod())) {
						parameterValue = StringUtil.encoding(parameterValue);
					}					
					paramMap.put(key.toUpperCase(), parameterValue);
					buffQuote.append("'" + parameterValue + "'");
					multiValueStringList.add(parameterValue);
					setMultiValue(request, multiValueMapList, handler, key.toUpperCase(), parameterValue);
					
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_QUOTE_POSTFIX, buffQuote.toString());
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_STRING_VALUES_POSTFIX, multiValueStringList);
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_VALUES_POSTFIX, multiValueMapList);
					
				}else{
					
					for(int i=0; i < values.length; i++) {
						String parameterValue = values[i];						
						if("GET".equals(request.getMethod())) {
							parameterValue = StringUtil.encoding(parameterValue);
						}
						
		            	if(i > 0) {
		            		// 체크박스 및 멀티콤보의 배열값
		            		buff.append("," + parameterValue);
		            		buffQuote.append(",'" + parameterValue + "'");
		            	} else {
		            		buff.append(parameterValue);
		            		buffQuote.append("'" + parameterValue + "'");
		            	}
		            	multiValueStringList.add(parameterValue);
		            	setMultiValue(request, multiValueMapList, handler, key.toUpperCase(), parameterValue);
		            }
					
					paramMap.put(key.toUpperCase(), buff.toString());
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_QUOTE_POSTFIX, buffQuote.toString());
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_STRING_VALUES_POSTFIX, multiValueStringList);
					paramMap.put(key.toUpperCase() + ProjectConstant.KEY_INTERCEPTOR_VALUES_POSTFIX, multiValueMapList);
				}
				copyParamMapToMultiMap(paramMap);
				if("mysql".equals(ProjectConstant.DATABASE_MODE)) convertEmptyToNull(paramMap);
				controller.setParamMap(paramMap);
			}
			if (reqMap.size() < 1) controller.setParamMap(paramMap);
		}
		return super.preHandle(request, response, handler);
	}
	
	private void setMultiValue(HttpServletRequest request, List multiValueList, Object handler, String key, String value) {
		Map multiMap = new HashMap<String, String>();
		multiMap.put(key, value);
		multiValueList.add(multiMap);
	}
	
	private void copyParamMapToMultiMap(Map<String, Object> paramMap) {
		Iterator itr = paramMap.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry value = (Map.Entry) itr.next();
			if(value.getValue() instanceof List) {
				List mapList = (List) value.getValue();
				for(int i=0; i < mapList.size(); i++ ) {
					if(mapList.get(i) instanceof Map) {
						copyMap(paramMap, (Map) mapList.get(i));
					}
				}
			}
		}
	}
	
	private void copyMap(Map<String, Object> paramMap, Map multiMap) {
		Iterator itr = paramMap.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry value = (Map.Entry) itr.next();
			if(value.getValue() instanceof String) {
				String itemValue = (String) value.getValue();
				String itemKey = (String) value.getKey();
				if(!multiMap.containsKey(itemKey)) multiMap.put(itemKey, itemValue);
			}
		}
	}
	
	/**
	 * 파라미터의 값에 ''(공백) 값을 null로 치환시킨다. (mysql일 경우 ''값이 null로 들어가지 않음) 
	 * @param paramMap
	 */
	private void convertEmptyToNull(Map<String, Object> paramMap) {
		Iterator itr = paramMap.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry value = (Map.Entry) itr.next();
			if(value.getValue() instanceof String) {
				if("".equals(value.getValue())) {
					value.setValue(null);
				}
			}
		}		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception ex) throws Exception {		
		// BaseController 일 경우에만 수행 
		if(handler instanceof BaseController) {
			logger.info("-------------- [core intercepter - ParameterSetInterceptor] controller에 파라미터맵(paramMap)을 해제합니다 -----------------");
			BaseController controller = (BaseController) handler;
			controller.clearParamMap();
		}		
		super.afterCompletion(request, response, handler, ex);
	}
}
