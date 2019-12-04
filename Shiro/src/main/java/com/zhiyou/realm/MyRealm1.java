package com.zhiyou.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * @author Administrator
 *	创建自定义域类实现认证
 *
 *	继承AuthenticatingRealm 只做认证功能
 */

public class MyRealm1 extends AuthorizingRealm{

	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 通过身份对象获得登录是的身份信息
		String username = (String)principals.getPrimaryPrincipal();
		System.out.println("授权获得身份信息:"+username);
		/*
		 * 调用业务层 方法查所有的角色
		 * List<String> roles = findRolesByUsername(username);
		 * 调用业务层方法 查所有权限
		 * Set set = new TrssSet();
		 * for(int i=0;i<roles.size;i++){
		 * 		List<String> resource = findResourceByRole(roles.get(i);
		 * 	//	set.add(resource);  // 权限去重
		 * }
		 */
		List<String> roles = new ArrayList<String>();
		roles.add("admin");
		roles.add("user");
		List<String> resource = new ArrayList<String>();
		resource.add("/user/select");
		resource.add("/user/delete");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(resource);
		return info;
	}
	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从token获取用户名
		/*
		 * Principal 身份
		 * Credentials 凭证 /密码
		 */
		String username = (String)token.getPrincipal();
		System.out.println("身份:"+username);
		Object credentials = token.getCredentials();
		System.out.println("凭证:"+credentials);
		/*
		 * 根据用户名,调用业务层service,查询用户信息,返回用户对象
		 * if(user == null)
		 * else
		 */
		/*
		 * 模拟 ,写死
		 */
		String un = "lisi";
		String pwd = "123456";
		/*
		 *比较 
		 */
		if(username.equals(un)) {
			System.out.println("找到该用户");
		}else{
			throw new IncorrectCredentialsException();
		}
		
		
		// 从数据库中查出的
		AuthenticationInfo info = new SimpleAuthenticationInfo(un,pwd,getName());
		return info;
	}

}
