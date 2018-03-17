package com.huiyx.upload.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huiyx.base.controller.BaseController;
import com.huiyx.framework.log.Log;
import com.huiyx.framework.log.LogFactory;
import org.apache.commons.codec.binary.Base64;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poster")
public class PosterController extends BaseController
{
	public final static Log log = LogFactory.getLog(PosterController.class);

	@RequestMapping("/createPoser")
	public void createPoster(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			// 设置头像
			//String  header = request.getParameter("header");
			//ByteArrayInputStream headerInputStream = getInputStream(header);

			File topHeader = new File("/huiyx/show/apache-tomcat-8.5.20/webapps/show/images/poster/topHeader.png");
			Image topHeaderImage = ImageIO.read(topHeader);
			// 获取头像的高
			int topHeaderHeight = 774;

			// 设置底部背景图
			File makerBack = new File("/huiyx/show/apache-tomcat-8.5.20/webapps/show/images/poster/makerBack3.png");
			Image makerBackImage = ImageIO.read(makerBack);

			// 设置图片的整体的宽度
			int imageWidth = makerBackImage.getWidth(null);

			int makerBackHeight = makerBackImage.getHeight(null);

			// 头像整体的高度
			int imageHeight = makerBackHeight + topHeaderHeight - 98;

			// logo标识
			File logo = new File( "/huiyx/show/apache-tomcat-8.5.20/webapps/show/images/poster/logo.png");
			Image logoImage = ImageIO.read(logo);

			BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = bufferedImage.createGraphics();

			// 获取logo的高
			int logoWidth = logoImage.getWidth(null);
			int logoHeigth = logoImage.getHeight(null);
			System.out.println("logoHeigth:" + logoHeigth);

			graphics.drawImage(topHeaderImage, 0, 0, imageWidth, topHeaderHeight, null);

			// 添加logo
			graphics.drawImage(logoImage, imageWidth - logoWidth - 50, 30, logoWidth, logoHeigth, null);

			graphics.drawImage(makerBackImage, 0, topHeaderHeight - 98, imageWidth, makerBackHeight, null);

			// 设置字体
			graphics.setColor(Color.white);
			graphics.setFont(new Font("黑体", Font.BOLD, 43));
			String agentName = "端木吉";
			String gradeName = "业务主任";
			// 业务员姓名字体的宽度
			int agentNameWidth = graphics.getFontMetrics().stringWidth(agentName);

			int gradeNameWidth = graphics.getFontMetrics().stringWidth(gradeName);
			// 水平居中
			int agentNameXLocation = (imageWidth - agentNameWidth - gradeNameWidth - 20) / 2;
			int agentNameYLocation = topHeaderHeight + 88;// y坐标
			graphics.drawString(agentName, agentNameXLocation, agentNameYLocation);

			graphics.setFont(new Font("黑体", Font.BOLD, 30));
			graphics.drawString(gradeName, agentNameXLocation + agentNameWidth + 20, agentNameYLocation);

			// 职称

			graphics.setFont(new Font("黑体", Font.PLAIN, 36));
			String tel = "手机：13212345678";
			graphics.drawString(tel, 50, topHeaderHeight + 180);

			String agentCode = "工号：10410131222444";
			graphics.drawString(agentCode, 50, topHeaderHeight + 250);

			String adds = "地址：北京市海淀区杏石口路9号合众大厦北京市海淀区杏石口路";

			List<String> addsList = subString(adds);
			int addsHeight = topHeaderHeight + 320;// 地址的y坐标位置
			for (int i = 0; i < addsList.size(); i++)
			{
				System.out.println(addsList.get(i));
				graphics.drawString(addsList.get(i), 50, addsHeight);
				addsHeight += 50;
			}

			// 添加二维码
			String  qr = request.getParameter("qrImage");
			ByteArrayInputStream qrInputStream = getInputStream(qr);

			Image qrImage = ImageIO.read(qrInputStream);
			int qrWidth = 173;
			int qrHeight = 172;
			
			//File qrCode = new File(MwpEnv.getProperty("poster_image") + "/QR.png");
			//Image qrImage = ImageIO.read(qrCode);
			//int qrWidth = qrImage.getWidth(null);
			// qrHeight = qrImage.getHeight(null);
			int qrXLocation = 50 + graphics.getFontMetrics().stringWidth(addsList.get(0)) + 70;
			int qrYLocation = topHeaderHeight + 150;
			graphics.drawImage(qrImage, qrXLocation, qrYLocation, qrWidth, qrHeight, null);

			// 添加钻石服务图片
			File diamond = new File( "/huiyx/show/apache-tomcat-8.5.20/webapps/show/images/poster/diamondService.png");

			Image diamondImage = ImageIO.read(diamond);
			int diamondWidth = diamondImage.getWidth(null);
			int diamondHeight = diamondImage.getHeight(null);
			System.out.println("addsHeight:" + addsHeight);
			graphics.drawImage(diamondImage, 0, addsHeight, diamondWidth, diamondHeight, null);

			// 添加五星
			File asterisk = new File( "/huiyx/show/apache-tomcat-8.5.20/webapps/show/images/poster/star.png");

			Image asteriskImage = ImageIO.read(asterisk);
			int asteriskWidth = asteriskImage.getWidth(null);
			int asteriskHeight = asteriskImage.getHeight(null);
			System.out.println("addsHeight:" + addsHeight);
			graphics.drawImage(asteriskImage, (imageWidth - asteriskWidth) / 2, addsHeight + asteriskHeight, asteriskWidth, asteriskHeight, null);

			graphics.dispose();
			// FileOutputStream out = new FileOutputStream("d:/1212/ccccc.png");
			//
			// ImageIO.write(bufferedImage, "JPEG", out);

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
			ImageIO.write(bufferedImage, "JPEG", imageOutput);
			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
			PrintWriter pw = response.getWriter();
			pw.write(Base64.encodeBase64String(data));
			pw.flush();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 获取图片流
	public static ByteArrayInputStream getInputStream(String imageStream)
	{
		log.info("imageStream："+imageStream);
		if (imageStream == null || "".equals(imageStream))
		{
			return null;
		}

		String[] images = imageStream.split(",");

		byte[] decoderByte = Base64.decodeBase64(images[1]);
		

		ByteArrayInputStream inputStream = new ByteArrayInputStream(decoderByte);

		return inputStream;
	}

	public static List<String> subString(String param)
	{
		int counts = 11;
		int length = param.length();
		System.out.println("adds:" + length);

		List<String> paramList = new ArrayList<String>();
		if (length <= counts)
		{
			paramList.add(param);
			return paramList;
		}

		int size = length / counts;
		int modeSize = length % counts;
		if (modeSize != 0)
		{
			size++;
		}
		System.out.println("size:" + size);

		for (int i = 0; i < size; i++)
		{
			if (i == size - 1)
			{
				paramList.add(param.substring(i * counts, length));
				break;
			}
			paramList.add(param.substring(i * counts, i * counts + counts));
		}
		return paramList;
	}

}
