package com.zhiyou.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 
 * @author Administrator
 *	演示
 *通过配置文件的形式实现认证
 *认证:判断用户名/密码  存在/不存在  对/不对
 */

public class TestShiro1 {
	/*
	 * 配置文件实现认证
	 */
	@Test
	public void testIniAuthentication() {
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-show.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将securityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject, 通过SecurityUtils得到
		Subject subject = SecurityUtils.getSubject();
		
		// 创建认证需要的对象:目前是固定的,应该从页面接收数据
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录:底层执行认证 
		/*
		 * 认证通过:正常
		 * 认证不通过: 抛异常
		 * 	1.账户不存在   未知账户异常
		 * 	2.密码不对   IncorrectCredentialsException
		 * 
		 */
		try {
			subject.login(token);
			System.out.println("登录成功");
		}catch (UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}
	}
	
	@Test
	public void testRealmAuthentication() {
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-show.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将securityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject, 通过SecurityUtils得到
		Subject subject = SecurityUtils.getSubject();
		
		// 创建认证需要的对象:目前是固定的,应该从页面接收数据
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录:底层执行认证 
		/*
		 * 认证通过:正常
		 * 认证不通过: 抛异常
		 * 	1.账户不存在   未知账户异常
		 * 	2.密码不对   IncorrectCredentialsException
		 * 
		 */
		try {
			subject.login(token);
			System.out.println("登录成功");
		}catch (UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}
	}
	// 配置文件实现的授权
	@Test
	public void testIniAuthoriztion() {
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-ini-author.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将securityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject, 通过SecurityUtils得到
		Subject subject = SecurityUtils.getSubject();
		
		// 创建认证需要的对象:目前是固定的,应该从页面接收数据
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456");
		// 执行登录:底层执行认证 
		/*
		 * 认证通过:正常
		 * 认证不通过: 抛异常
		 * 	1.账户不存在   未知账户异常
		 * 	2.密码不对   IncorrectCredentialsException
		 * 
		 */
		try {
			subject.login(token);
			System.out.println("登录成功");
			/*
			 * 判断用户有无对应的角色  权限
			 */
		//	System.out.println(subject.hasRole("role1"));
			List<String> roles = new ArrayList<String>();
			roles.add("role1");
			roles.add("role2");
			roles.add("role3");
			// 判断有无哪几个角色
			for(int i=0;i<subject.hasRoles(roles).length;i++) {
				System.out.println("有无角色"+(i+1)+" "+subject.hasRoles(roles));
			}
			/*
			 * 判断有无权限
			 */
			System.out.println("有无/user/add权限?"+subject.isPermitted("/user/add"));;
		}catch (UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}
	}
	
	
	@Test
	public void testRealmAuthoriztion() {
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-realm-author.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将securityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject, 通过SecurityUtils得到
		Subject subject = SecurityUtils.getSubject();
		
		// 创建认证需要的对象:目前是固定的,应该从页面接收数据
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456");
		// 执行登录:底层执行认证 
		/*
		 * 认证通过:正常
		 * 认证不通过: 抛异常
		 * 	1.账户不存在   未知账户异常
		 * 	2.密码不对   IncorrectCredentialsException
		 * 
		 */
		try {
			subject.login(token);
			System.out.println("登录成功");
			/*
			 * 判断用户有无对应的角色  权限
			 */
		//	System.out.println(subject.hasRole("role1"));
			List<String> roles = new ArrayList<String>();
			roles.add("role1");
			roles.add("role2");
			roles.add("role3");
			// 判断有无哪几个角色
			for(int i=0;i<subject.hasRoles(roles).length;i++) {
				System.out.println("有无角色"+(i+1)+" "+subject.hasRoles(roles));
			}
			/*
			 * 判断有无权限
			 */
			System.out.println("有无/user/add权限?"+subject.isPermitted("/user/add"));;
		}catch (UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}
	}
	
}
