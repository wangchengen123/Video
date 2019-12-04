package com.zhiyou.proxy;

/**
 * @author Administrator
 * 酒厂代理类:主要功能是卖家
 */
public class WineProxy {

	WineFactory wf = new WineFactory();
	
	
	public void sellWine() {
		System.out.println("拉客户");
		wf.sell();
		System.out.println("回访");
	}
	
	
}
