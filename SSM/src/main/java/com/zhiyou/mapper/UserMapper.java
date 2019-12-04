package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.User;

// 保持接口的权限定名与mapper中的namespace一致
public interface UserMapper {

	void add(User user); // 方法名保持与对应的mapper中的id一致

	void update(User user);// 参数与mapper中的parameterType

	void delete(int id);

	List<User> selectAll(Map<String, Object> map);// 返回值跟 mapper中的resultType一致

	List<User> select(User user);// 传入任何参数都能查询

	List<User> selectLike(User user);// 传入任何参数都能进行模糊查询

	void deleteAll(int[] ids); // 批量删除

	User selectByID(int id);

	User selectByName(String name);

}
