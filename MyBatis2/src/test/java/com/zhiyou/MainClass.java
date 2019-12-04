package com.zhiyou;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.mapper.DeptMapper;
import com.zhiyou.mapper.EmpMapper;
import com.zhiyou.model.Dept;
import com.zhiyou.model.Emp;

public class MainClass {

	@Test
	public void add() throws IOException, InterruptedException {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sql = sf.openSession();
		SqlSession sql2 = sf.openSession();
		Dept dept = new Dept(null, "开发部2", "月球1");
		Emp emp = new Emp(null,"张三2","前端工程师1",null,new Date(),null, null, 11000,dept);	
		// 关系交给多的一方来保存
		EmpMapper empMapper = sql.getMapper(EmpMapper.class);
		DeptMapper deptMapper = sql.getMapper(DeptMapper.class);
		EmpMapper empMapper2 = sql2.getMapper(EmpMapper.class);
		deptMapper.add(dept);
		empMapper.add(emp);		
	//	empMapper.delete(42);
	//	deptMapper.delete(42);
	//	Emp emp2 = empMapper.selectByID(7839);
	/*	System.out.println("++++++"+emp2.getEname());
		Thread.sleep(8000L);
		System.out.println(emp2.getDept());	*/
		List<Emp> list = empMapper.selectAll();	
		sql.clearCache();
		empMapper.selectAll();
		sql.clearCache();
		empMapper.selectAll();
		sql.clearCache();
		empMapper.selectAll();
//		empMapper2.selectAll();
		// 提交事务
		sql.commit();
		sql.close();
		reader.close();
	}
	
	@Test
	public void select() throws IOException, InterruptedException {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sql = sf.openSession();
		DeptMapper deptMapper = sql.getMapper(DeptMapper.class);
		deptMapper.selectByID(10);
		sql.close();
		reader.close();
	}
	@Test
	public void dept() throws IOException, InterruptedException {

	Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
	SqlSession sql = sf.openSession();	
	SqlSession sql2 = sf.openSession();	
	DeptMapper deptMapper = sql.getMapper(DeptMapper.class);
	DeptMapper deptMapper2 = sql2.getMapper(DeptMapper.class);
	System.out.println(deptMapper.selectByID(10));	
	sql.close();
	System.out.println(deptMapper2.selectByID(10));	
	sql2.close();
	}
	
	@Test
	public void dept2() throws IOException, InterruptedException {

	Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
	SqlSession sql = sf.openSession();	
	DeptMapper deptMapper = sql.getMapper(DeptMapper.class);
	Map<String,String> map = new HashMap<String, String>();
	map.put("dname", "开发部");
	map.put("locc", "月球");
	// deptMapper.selectByNameAndByLoc(map);
	
	}
	
	@Test
	public void dept3() throws IOException, InterruptedException {
	Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
	SqlSession sql = sf.openSession();	
	DeptMapper deptMapper = sql.getMapper(DeptMapper.class);
	deptMapper.selectByNameAndByLoc("'开发部'","'月球'");
	deptMapper.selectAllOrderBy("sal");
	}
	
	@Test
	public void dept4() throws IOException, InterruptedException {
	Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
	SqlSession sql = sf.openSession();	
	EmpMapper mapper = sql.getMapper(EmpMapper.class);
	mapper.selectAll();
	}
	
}
