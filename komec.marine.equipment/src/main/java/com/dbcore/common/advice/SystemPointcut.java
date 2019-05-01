package com.dbcore.common.advice;

import org.aspectj.lang.annotation.Pointcut;

public final class SystemPointcut {

	private SystemPointcut() {
		
	}
	
	@Pointcut("execution(* egovframework.rte.psl.dataaccess.EgovAbstractDAO..*(..))")
	public void daoExecution() {}
	
	@Pointcut("execution(* *..controller..*(..))")
	public void controllerExecution() {}
	
	
	
}



