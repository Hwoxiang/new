package com.huiyx.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiyx.po.user.User;
import com.huiyx.user.dao.UserDao;
import com.huiyx.user.service.UserService;
import com.huiyx.user.vo.UserVO;
import com.huiyx.util.DateUtils;

@Service("uservice")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;


	@Override
	public long addUser(UserVO userVO) throws Exception
	{
		User user = new User();
		user.setRealName(userVO.getRealName());
		user.setUserName(userVO.getUserName());
		user.setPassWord(userVO.getPassword());
		user.setUserState("1");
		userDao.addUser(user);
		return user.getUserId();
	}

	@Override
	public User getUserById(long userId)
	{
		return null;
	}

	@Override
	public List<UserVO> getUserVOList()
	{
		List<User> userList = userDao.getUserList();
		if (userList == null || userList.size() <= 0)
		{
			return null;
		}

		List<UserVO> userVOList = new ArrayList<UserVO>();
		for (User user : userList)
		{
			UserVO userVO = new UserVO();
			userVO.setRealName(user.getRealName());
			userVO.setUserName(user.getUserName());
			userVO.setUserId(user.getUserId());
			userVO.setInsertTime(DateUtils.toString(user.getInsertTime()));
			userVO.setUpdateTime(DateUtils.toString(user.getUpdateTime()));
			userVOList.add(userVO);
		}
		return userVOList;
	}

	@Override
	public void deleteUserById(long userId)
	{
		userDao.deleteUserById(userId);
	}

}
