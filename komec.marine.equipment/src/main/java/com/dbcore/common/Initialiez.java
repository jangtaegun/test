package com.dbcore.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.dbcore.common.vo.LoginInfoVo;

public class Initialiez extends HttpServlet implements ServletContextListener {

	private static final long serialVersionUID = 3429491628440024287L;
	private final Logger logger = Logger.getLogger(getClass());
	private static LoginInfoVo loginInfoVo = new LoginInfoVo();

	/**
	 * 
	 */
		
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			// TODO Auto-generated method stub
		logger.info("//---------------------------------------------------//");
		logger.info("//***************userInfo Initialized****************//");
		logger.info("//---------------------------------------------------//");
		
		LoginInfoVo loginInfoVo= this.getInstance();
			
		LoginInfoVo.setChnlIdInfo("admin");
		LoginInfoVo.setUseInitIdInfo("agent");
		}

		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			
		}
		
		public static LoginInfoVo getInstance(){
			return loginInfoVo;
		}



}

