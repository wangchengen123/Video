package com.zhiyou;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;

public class MainClass2 {

	@Test
	public void add() throws Exception {
		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		User user = new User(20, "罗志祥", "小猪", "123456", 80, 38);
		// 通过动态代理，给我们的接口创建了一个代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		// 由于代理对象中存在sqlsession，所以可以进行数据库的查询
		mapper.add(user);
		// 提交事务
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void delete() throws Exception {
		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		// 通过动态代理，给我们的接口创建了一个代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		// 由于代理对象中存在sqlsession，所以可以进行数据库的查询
		mapper.delete(20);
		// 提交事务
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void update() throws Exception {
		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		User user = new User(20, "罗志祥", null, null, 80, 38);
		UserMapper mapper = session.getMapper(UserMapper.class);
		// 由于代理对象中存在sqlsession，所以可以进行数据库的查询
		mapper.update(user);
		// 提交事务
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void selectAll() throws Exception {

		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAll();
		session.close();
		reader.close();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void select() throws Exception {

		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		User user = new User(20, null, null, "123456", 0, 0);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.select(user);
		session.close();
		reader.close();
		for (User user1 : list) {
			System.out.println(user1);
		}
	}

	@Test
	public void selectLike() throws Exception {

		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		User user = new User(0, null, null, "1456", 0, 0);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectLike(user);
		session.close();
		reader.close();
		for (User user1 : list) {
			System.out.println(user1);
		}
	}

	@Test
	public void deleteAll() throws Exception {

		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();

		UserMapper mapper = session.getMapper(UserMapper.class);
		int[] arr = { 1, 3, 4, 5 };
		mapper.deleteAll(arr);
		session.close();
		reader.close();

	}
}