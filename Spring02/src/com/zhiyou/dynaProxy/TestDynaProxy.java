package com.zhiyou.dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestDynaProxy {
	@Test
	public void testProxy() {
		// 创建代理对象需要执行目标方法的类
		JDKProxy jdkProxy = new JDKProxy(new WineFactoryImpl());
		// JDK的动态代理,生成代理对象
		
		/*
		 * loader:目标类的类加载器
		 * interfaces:目标类的所有接口
		 */
		/*
		 * JDK动态代理 代理的是目标类的接口
		 * 所以返回的也是目标类的接口
		 */
		WineFactory wf = (WineFactory)Proxy.newProxyInstance(WineFactoryImpl.class.getClassLoader(),
				WineFactoryImpl.class.getInterfaces(),
				jdkProxy);
	//	wf.sell();
	}
}
