package com.zhiyou.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhiyou.model.User;
import com.zhiyou.service.LoginService;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private LoginService loginService;
	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("admin");
		info.addStringPermission("user/update");
		System.out.println("授权:admin");
		return info;
	}
	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 根据登录token 去数据库查用户
		User user = loginService.findUserByUsername(token.getPrincipal());
		if(user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(user.getName(),user.getPassword(),getName());
		
		return info;
	}

}
