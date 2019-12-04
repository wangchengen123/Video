package com.zhiyou.proxy;

import org.junit.Test;

public class TestProxy {
	public static void main(String[] args) {
		
		//买酒
		WineFactory wf = new WineFactory();
		wf.sell();
	}
	@Test
	public void testProxy1() {
		// 买酒
		WineProxy wp = new WineProxy();
		wp.sellWine();
		/*
		 * 代理模式:就是改变对象的访问方式
		 * 将原来直接访问目标类的方式  变为访问目标类的代理对象
		 */
	//==========================================================
		/*
		 * 以上代理模式叫做静态代理
		 *   代理类不灵活,每需要一个代理就需要自己创建一个代理类
		 */
	}
	
	
}
