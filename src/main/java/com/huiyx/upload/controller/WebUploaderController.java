package com.huiyx.upload.controller;

import com.huiyx.base.controller.BaseController;
import com.huiyx.framework.log.Log;
import com.huiyx.framework.log.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

@Controller() @RequestMapping("/webUploader") public class WebUploaderController extends
		BaseController
{
	public final static Log log = LogFactory.getLog(WebUploaderController.class);

	@RequestMapping("/uploadImage") public void uploadImage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			log.info("enter into uploadImage method");
			MultipartHttpServletRequest murequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = murequest.getFileMap();//得到文件map对象
			if (files == null)
			{
				writeJson(response,"没有图片");
				return;
			}

			String upaloadUrl = "/huiyx/image/";
			for (MultipartFile file : files.values())
			{
				String fileName = file.getOriginalFilename();
				File tagetFile = new File(upaloadUrl + fileName);//创建文件对象
				log.info("tagetFile:" + tagetFile);
				if (!tagetFile.exists())
				{
					tagetFile.createNewFile();
					file.transferTo(tagetFile);
				}
			}
			writeJson(response,"上传成功");
		} catch (Exception e)
		{
			log.error("上传失败:",e);
			writeJson(response,"上传失败");
		}

	}

}
