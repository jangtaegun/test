package com.dbcore.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dbcore.common.vo.LoginInfoVo;

@org.springframework.stereotype.Controller("sessionUserInterceptor")
public class SessionUserInterceptor  extends HandlerInterceptorAdapter {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(logger.isDebugEnabled()) {	
			logger.debug("-------------- [core intercepter - SessionUserInterceptor] 수행합니다. -----------------");
		}
		
		
		// 요청 페이지가 login 인 경우 true 처리
//		String requestAction = request.getRequestURI();
//		if( requestAction != null && ( requestAction.equals("/main.do") || requestAction.equals("/login.do") || requestAction.equals("/session_expire.do") ) ) 
//				return true;
//
//		HttpSession session = request.getSession();
//		CoreUserInfoVO login_user = (CoreUserInfoVO)session.getAttribute("LoginUserVO");
//		
//		if(session == null || login_user == null || login_user.getUser_id() == null || (login_user.getUser_id()).equals("")) {
//			response.sendRedirect(sessionExpirePage());
//			return false;
//		}		
		return true;
	}
	
	public String sessionExpirePage() {
		return "/session_expire.do";
	}
}
