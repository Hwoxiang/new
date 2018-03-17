package com.huiyx.user.service;

import java.util.List;

import com.huiyx.po.user.User;
import com.huiyx.user.vo.UserVO;

public interface UserService
{
	//保存用户
	public long addUser(UserVO userVO) throws Exception;
	
	//通过userId获取用户信息
	public User getUserById(long userId);
	
	//获取用户列表
	public List<UserVO> getUserVOList();
	
	public void deleteUserById(long userId);

}
