package com.zhiyou.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * 切面类
 * 增强/通知
 */
@Component    //组件注解,使该类由Spring托管
@Aspect     //声明该类是一个切面类
public class MyAspect {
	
	
	/*
	 * 这个方法,只用于声明切入点表达式
	 *  注意用于承载@Pointcrt注解
	 *  
	 *  就相当于是
	 * <aop:pointcut expression="execution(* 
	 * com.zhiyou100.springAspectJAOP.UserServiceImpl.*(..))"
	 * id="myPointCut"/>
	 * 该方法名就类似于id 
	 */
	
	//前置通知注解:目标方法前执行
	//注解后:是切入点表达式,或者是引用另一个切入点表达式的id
	// 引用另一个切入点表达式时,其实是一个方法的方法名,需要加()
	@Before("myPointcut()")
	public void myBefore() {
		System.out.println("AspectJ  前置通知:权限校验");
	}
	
	//后置通知:目标方法后执行
	@After("myPointcut()")
	public void myAfter() {
		System.out.println("AspectJ 后置通知:日志记录");
	}
	
	/*
	 * BUG:@AfterReturning注解所在的方法,参数是JoinPoint.不然报错
	 */
	@AfterReturning("myPointcut()")
	public void myAfterReturn(JoinPoint jp) {
		System.out.println("AspectJ  后置返回通知:获得的返回值是"+jp);
	}
	
	// 环绕通知:目标方法执行前后都执行
	// 得让目标方法执行,所有需要添加参数:org.aspectj.lang.ProceedingJoinPoint
	//可以认为,该参数就是 目标方法
	@Around("myPointcut()")
	public void myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("AspectJ 环绕通知: 前");
		
		//  让目标方法执行
		joinPoint.proceed();
		System.out.println("AspectJ 环绕通知:后");
	}
	
	
	@Pointcut("execution(* com.zhiyou.service.UserServiceImpl.*(..))")
	public void myPointcut() {
		
	}

}
