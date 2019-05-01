package com.dbcore.common.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionThrowsAdvice {

	protected final Log logger = LogFactory.getLog(getClass());

	public void exceptionThrowing(Exception ex) throws Throwable {
		if (logger.isDebugEnabled()) {

			logger.debug("==========================>>>  "+ex.getClass().getName() + " 에서 Exception Check 시작!");
		}

		if( logger.isErrorEnabled() ) {
			logger.error(ex.getMessage(), ex);
		}


		if (logger.isDebugEnabled()) {
			logger.debug("==========================>>>  "+ex.getClass().getName() + " 에서 Exception Check 종료!");
		}
	}
 }
