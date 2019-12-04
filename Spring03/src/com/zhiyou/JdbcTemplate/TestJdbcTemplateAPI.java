package com.zhiyou.JdbcTemplate;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Administrator
 * 使用JdbcTemplate原生API
 */
public class TestJdbcTemplateAPI {
	public static void main(String[] args) {
		//1. 创建DBCP数据库连接池对象
		BasicDataSource dataSource = new BasicDataSource();
		// 设置数据源
		// 驱动
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// 数据库地址
		dataSource.setUrl("jdbc:mysql://localhost:3306/day19");
		// 数据库用户名
		dataSource.setUsername("root");
		// 数据库密码
		dataSource.setPassword("123456");
		
		//2. 创建JdbcTemplate
		JdbcTemplate temp = new JdbcTemplate();
		
		//3. 给模板注入数据源
		temp.setDataSource(dataSource);
		
		//4. 执行SQL
		// 删除
//		String sql = "delete from users where id = ?";
//		temp.update(sql,23);
		// 插入
//		String sql = "insert into users values (?,?,?,?)";
		// 不定长参数的顺序与类型要与SQL语句的参数对应
//		temp.update(sql,34,"小明","123",new Date());
		
		// 查询一个对象
		String sql = "select * from users where id = ?";
	//	User user = temp.queryForObject(sql, new MyRowMapper(),23);
		
		
		
	}

}
