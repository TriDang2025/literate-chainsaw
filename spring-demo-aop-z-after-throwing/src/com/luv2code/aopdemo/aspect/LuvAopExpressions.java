package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create point cut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create point cut: include package ... exclude getter/setter 
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}