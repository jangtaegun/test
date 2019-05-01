package com.dbcore.common.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dbcore.common.util.StringUtil;

@org.springframework.stereotype.Controller("parameterLoggingInterceptor")
public class ParameterLoggingInterceptor extends HandlerInterceptorAdapter {
		
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("-------------- [core intercepter - ParameterLoggingInterceptor] request에 있는 파라미터의 로깅을 수행합니다. -----------------");
		logger.info("HTTP REQUEST MATHOD : " + request.getMethod());
		logger.info("HTTP REQUEST ENCODING : " + request.getCharacterEncoding());
		
		Map<String, String[]> reqMap = request.getParameterMap();
		for(String key : reqMap.keySet()) {
			StringBuffer buff = new StringBuffer();
			buff.append("[ ");
            buff.append("파라미터키: " + key.toUpperCase()); 
            
            String[] values = (String[]) reqMap.get(key);
            buff.append("\t파라미터값: ");
            for(int i=0; i < values.length; i++) {
            	if(i > 0) {
            		if("GET".equals(request.getMethod())) {
            			buff.append("," + StringUtil.encoding(values[i])); 
            		} else {
            			buff.append("," + values[i]);
            		}
            	} else {
            		if("GET".equals(request.getMethod())) {
            			buff.append(StringUtil.encoding(values[i]));
            		} else {
            			buff.append(values[i]);
            		} 
            	}
            }
            buff.append(" ]");
            logger.info(buff.toString());
		}
        return super.preHandle(request, response, handler);
    }
}
