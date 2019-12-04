package com.zhiyou.springAOP;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author Administrator
 * 切面类:定义各种通知
 * 	各种增强方法
 * 
 * MethodInterceptor:环绕通知:在目标方法执行前后都可以做一下功能
 * MethodBeforeAdvice:前置通知:在目标方法执行前做一些功能
 * AfterAdvice		:后置通知:在目标方法后执行
 * AfterReturningAdvice:后置返回通知
 * 
 */
public class MyAspect implements MethodInterceptor{

	/*
	 * MethodInterceptor: 目标方法
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("权限认证");
		// 目标方法
		invocation.proceed();
		System.out.println("日志记录");
		return null;
	}

	

}
