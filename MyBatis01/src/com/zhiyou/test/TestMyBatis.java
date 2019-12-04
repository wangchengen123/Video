package com.zhiyou.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;

public class TestMyBatis {
	public static void main(String[] args) {
		
	}
	/**
	 * JUnit 的前置通知/增强 在任何一个JUnit方法执行前执行的代码
	 * 将加载配置文件,获得SqlSessionFactory,已经得到SqlSession的过程全部抽取
	 * 
	 * @throws IOException
	 */
	SqlSession sqlSession = null;
	@Before
	public void getSqlSession() throws IOException {
		// 1.加载Mybatis全局配置变量
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.通过全局配置文件得到SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过SqlSessionFactory得到SqlSession
		/*
		 * 参数true:自动提交事务
		 * 参数false:
		 */
		sqlSession = sqlSessionFactory.openSession();
	}

	/**
	 * 单元测试:主方法的简化版 返回值为void 方法名不能叫test
	 * 
	 * @throws IOException
	 * 
	 * 
	 *             执行单元测试的方法, 执行哪一个方法,光标选中该方法,再右键执行JUnti
	 */


	@Test
	public void selectAll() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		List<User> users = userMapper.findAllUser();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void selectAllById() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		User user = userMapper.findUserById(3);
		System.out.println(user);
	}

	@Test
	public void selectAllByName() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		User user = userMapper.findUserByName("zs");
		System.out.println(user);
	}

	@Test
	public void insertUser() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		User u = new User();
		u.setId(5);
		u.setName("张三");
		u.setPassword("123");
		u.setBirthday(new Date());
		userMapper.insertUser(u);
		/* JDBC默认自动开启事务,提交事务
		 * Mybates默认是手动提交事务,不是自动
		 * 所以:执行增删改 需要提交事务
		 */
		sqlSession.commit();
		
	}
	
	@Test
	public void selectUserByNameandPasswordMap() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		User user = userMapper.findUserByName("zs");
		System.out.println(user);
	}
	// 模糊查询
	@Test
	public void findUserByKeyword() throws IOException {
		// 4.通过SqlSession得到Mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 5.通过代理对象执行sql
		List<User> users = userMapper.findUserByKeyword("");
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
}
