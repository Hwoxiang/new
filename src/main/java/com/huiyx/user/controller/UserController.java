package com.huiyx.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.huiyx.base.controller.BaseController;
import com.huiyx.framework.log.Log;
import com.huiyx.framework.log.LogFactory;
import com.huiyx.user.service.UserService;
import com.huiyx.user.vo.UserVO;
import com.huiyx.vo.ResultVO;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
	private final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	// 去注册用户
	@RequestMapping("/registerUser")
	public ModelAndView registerUser()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userRegister");
		return mav;
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(UserVO userVO)
	{
		if (userVO == null)
		{
			log.info("userVO is null");
			return null;
		}

		try
		{
			log.info("userVO:{}", JSONObject.toJSON(userVO));
			long userId = userService.addUser(userVO);
			log.info("userId:{}", userId);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	// 获取用户列表
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	public void getUserList(HttpServletResponse response)
	{
		List<UserVO> userVOList = userService.getUserVOList();
		if (userVOList == null)
		{
			log.info("userVOList is null");
			return;
		}
		writeJson(response, userVOList);
		return;
	}

	// 通过userId删除用户
	@RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
	public void deleteUserById(HttpServletResponse response, @RequestParam("userId") long userId)
	{
		log.info("userId:{}", userId);

		userService.deleteUserById(userId);
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("200");
		writeJson(response, resultVO);
		return;
	}

}
