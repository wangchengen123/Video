package com.zhiyou.dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * 代理类执行方法
 * 
 * 用于;JDK的动态代理生成的目标类的代理对象,代理对象来此处执行目标类的方法
 */
public class JDKProxy implements InvocationHandler{

	// 目标类:被代理的对象
	private Object target;
	public JDKProxy(Object target) {
		this.target = target;
	}
	
	/**
	 * proxy:生成的代理对象
	 * method:目标类的方法
	 * args:目标类方法的参数
	 * 返回值:目标类方法执行后的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理拉客户");
		// 让目标类的方法执行
		/*
		 * obj:该方法被哪个对象执行
		 * args:该方法的参数
		 */
		method.invoke(target, args);
		System.out.println("代理维护客户");
		return null;
	}

}
