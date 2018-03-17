package com.huiyx.util;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;

public class MainDemo
{
//	private static final String MEDICAL_SECRET_KEY = "10QHX8jxKCzfxpJY1ZncRV+TQ+y9AeOU";
//	private static final String MEDICAL_SALT = "DFbu78jde3Ws343Fssd32145/DFAaDDF2456DF435b42FG34dsLDRsEeRT";

	
//	public static void dataServer(HttpServletRequest request, HttpServletResponse response)
//	{
//		BufferedReader br = request.getReader();
//		String str = br.readLine();
//		StringBuilder builder = new StringBuilder();
//		while (str != null)
//		{
//			builder.append(str);
//			str = br.readLine();
//		}
//		String encryptData = builder.toString();
//		// 对数据进行解密,decryptMedicalData为用户数据
//		//String decryptMedicalData = decryptData(encryptData);
//
//		HashMap<String, String> hashMap = new HashMap<String, String>();
//		hashMap.put("resultCode", "200");
//		hashMap.put("validateDate", "2017-12-22");
//		hashMap.put("endDate", "2018-12-21");
//		hashMap.put("medicalCardCode", "MC20171227000000704");
//		hashMap.put("dataTo", "合众人寿");
//
//		// 对返回的数据进行加密
//		//String medicalBackData = encryptData(JSONObject.toJSONString(hashMap));
//		response.getWriter().print(medicalBackData);
//		response.getWriter().close();
//		return;
//	}
//
//	// 对数据进行加密
//	private String encryptData(String backData) throws Exception
//	{
//		// 先对数据进行加密生成加密数据
//		byte[] encryptBackData = MedicalAESCoder.encrypt(backData.getBytes("UTF-8"), MEDICAL_SECRET_KEY);
//
//		// 加密的数据进行base64转码加盐生成摘要
//		String digestMessage = MedicalAESCoder.createDigest(encryptBackData, MEDICAL_SALT);
//
//		// 将加密的数据进行base64编码
//		String encryptData = Base64.encodeBase64String(encryptBackData);
//
//		// 将加数据数据和摘要转化为json字符串
//		Map<String, String> dataMap = new HashMap<String, String>();
//		dataMap.put("medicalBackData", encryptData); // 加密后的数据
//		dataMap.put("digestMessage", digestMessage);// 摘要
//		String medicalBackData = JSONObject.toJSONString(dataMap);
//		log.info("***********medicalBackData:" + medicalBackData);
//		return medicalBackData;
//	}
//
//	// 对数据进行解密
//	private String decryptData(String encryptData) throws Exception
//	{
//		// 1、将json字符串转化为json类型
//		JSONObject json = JSONObject.parseObject(encryptData);
//		// 获取摘要
//		String digest = (String) json.get("digestMessage");
//		// 获取加密的数据
//		String medicalData = (String) json.get("medicalData");
//		// 2、生成摘要
//		String createDigest = MedicalAESCoder.createDigest(medicalData, MEDICAL_SALT);
//
//		// 3、判断两个摘要是否相等
//		if (!MedicalAESCoder.validata(digest, createDigest))
//		{
//			throw new Exception("数据被篡改");
//		}
//		// 4、解密
//		byte[] decryptData = MedicalAESCoder.decrypt(medicalData, MEDICAL_SECRET_KEY);
//		String decryptMedicalData = new String(decryptData, "UTF-8");
//		return decryptMedicalData;
//	}

}
