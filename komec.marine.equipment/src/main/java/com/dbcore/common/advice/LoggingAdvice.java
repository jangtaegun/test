package com.dbcore.common.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAdvice {

	protected final Log logger = LogFactory.getLog(getClass());

	@Around("SystemPointcut.daoExecution()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {		
        String targetClassName = pjp.getTarget().getClass().getName();
        String targetMethodName = pjp.getSignature().getName();
        
   	    if (logger.isInfoEnabled()) {   	    	
   		    logger.info("==========================>>>  "+targetClassName + "." + targetMethodName + " 시작!");
    	    Object[] args = pjp.getArgs();

    	    for (int i = 0; i < args.length; i++) {
    	    	if( i == 0 ) {
    	    		logger.info("arg[" + i + "] mapId : " + args[i]);
    	    	} else {
    	    		logger.info("arg[" + i + "] : " + args[i]);
    	    	}
    	    }    	   
        }

   	    Object returnValue = pjp.proceed();

   	    if (logger.isInfoEnabled()) {
   	    	logger.info("==========================>>>  "+targetClassName + "." + targetMethodName + " 종료!");
   	    }
   	    return returnValue;
	}
	
	@Around("SystemPointcut.daoExecution()")
	public Object daoMonitoring(ProceedingJoinPoint pjp) throws Throwable {

		StopWatch clock = new StopWatch("Profiling ...");
		Object returnValue;

		try {
			clock.start(pjp.toShortString());
			returnValue = pjp.proceed();
		} finally {
			clock.stop();
		}

		if( clock.getTotalTimeMillis() > 500 ) {
			if (logger.isWarnEnabled()) {
				logger.warn("==========================>>>  DAO Execution Location : " + pjp.getTarget().getClass().getName());
				logger.warn("==========================>>>  DAO Execution Method : " + pjp.toShortString());
				logger.warn("==========================>>>  DAO Execution Time : " + clock.prettyPrint());
			}
		}
		return returnValue;
	}
}
