package com.huiyx.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.huiyx.framework.log.Log;
import com.huiyx.framework.log.LogFactory;

@Controller
@RequestMapping("/base")
public class BaseController
{
	private final Log log = LogFactory.getLog(BaseController.class);
	
	@RequestMapping("/writeJson")
	public void writeJson(HttpServletResponse response, Object obj)
	{
		String jsonStr = JSONObject.toJSONString(obj);

		response.setContentType("application/json");

		writeOut(response, jsonStr);
	}

	private void writeOut(HttpServletResponse response, String jsonStr)
	{
		// 清理目标页面缓存
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		PrintWriter pw = null;
		try
		{
			pw = response.getWriter();
			pw.write(jsonStr);
			pw.flush();
		} catch (IOException e)
		{
			log.error("writeOut IOException", e);
		} finally
		{
			if (pw != null)
			{
				pw.close();
			}
		}
	}

}
