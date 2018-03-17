package com.huiyx.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.huiyx.po.user.User;

@Repository public interface UserDao
{
	//添加user
	long addUser(User user);

	//通过userId获取用户
	User getUserById(long userId);

	//对姓名进行模糊查询
	List<User> getUserByIncludeValue(@Param("realName") String realName);

	List<User> getUsersByRealName(@Param("realName") String realName);

	//获取所有的用户
	List<User> getUserList();

	//通过userId删除元素
	void deleteUserById(@Param("userId") long userId);
}
