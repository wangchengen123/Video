package com.zhiyou;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.model.User;

public class MainClass {

	@Test
	public void add() throws Exception {
		// 读取配置文件信息，获得一个流
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件或得到一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话
		SqlSession session = sf.openSession();
		User user = new User(20, "罗志祥", "小猪", "123456", 80, 38);
		session.insert("woyesuibianqiao.nixinbuxin.add", user);
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

		session.delete("woyesuibianqiao.nixinbuxin.delete", 20);
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

		session.insert("woyesuibianqiao.nixinbuxin.update", new User(20, "罗123", "小猪", "123456", 80, 38));
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
		List<User> list = session.selectList("woyesuibianqiao.nixinbuxin.selectAll");

		// 提交事务
//		session.commit();
		session.close();
		reader.close();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
