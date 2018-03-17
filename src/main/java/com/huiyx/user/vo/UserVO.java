package com.huiyx.user.vo;

public class UserVO
{
	private long userId;
	private String userName; // 手机号
	private String realName;// 用户真实姓名
	private String password;// 用户密码
	private String indexPwd;// 确认密码

	private String insertTime;// 插入时间
	private String updateTime;// 更新时间

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getIndexPwd()
	{
		return indexPwd;
	}

	public void setIndexPwd(String indexPwd)
	{
		this.indexPwd = indexPwd;
	}

	public String getInsertTime()
	{
		return insertTime;
	}

	public void setInsertTime(String insertTime)
	{
		this.insertTime = insertTime;
	}

	public String getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}
}
