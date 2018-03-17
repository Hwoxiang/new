package com.huiyx.upload.controller;

import com.huiyx.base.controller.BaseController;
import com.huiyx.framework.log.Log;
import com.huiyx.framework.log.LogFactory;
import com.huiyx.util.DateUtils;
import com.huiyx.vo.ResultVO;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller @RequestMapping("/upload") public class UploadController
		extends BaseController
{
	private final Log log = LogFactory.getLog(UploadController.class);

	@RequestMapping("/interUpload")
	public ModelAndView interUpload()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/upload/uploadImage");
		return mav;
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST) public void uploadImage(HttpServletRequest request, HttpServletResponse response)
	{
		ResultVO resultVO = new ResultVO();

		String files = request.getParameter("files");
		log.info("files:{}", files);

		if (files == null || "".equals(files))
		{
			resultVO.setResultCode("201");
			resultVO.setErrorMessage("上传的图片不正确");
			writeJson(response, resultVO);
			return;
		}

		String[] images = files.split(",");
		log.info("images[0]:{}", images[0]);
		log.info("images[1]:{}", images[1]);

		byte[] decoderByte = Base64.decodeBase64(images[1]);

		String imageFilePath = "/Users/huiyongxian/Desktop/123/" + DateUtils.getDataString() + ".jpg";

		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream(imageFilePath);
			out.write(decoderByte);
			resultVO.setResultCode("200");
			writeJson(response, resultVO);
			return;
		} catch (Exception e)
		{
			log.error("has exception:", e);
		} finally
		{
			if (out != null)
			{
				try
				{
					out.close();
				} catch (IOException e)
				{
					log.error("has ioexception:", e);
				}
			}
		}
	}



}
