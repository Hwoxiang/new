package com.huiyx.util;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class MedicalAESCoder
{
	// 密钥算法
	public static final String ALGORITHM = "AES";

	// 加密/解密算法 /工作模式/填充方式
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	// 转换密钥
	private static Key toKey(byte[] key) throws Exception
	{
		// 实例化AES密钥材料
		try
		{
			KeyGenerator generator = KeyGenerator.getInstance(MedicalAESCoder.ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key);
			generator.init(128, secureRandom);
			return generator.generateKey();
		} catch (Exception e)
		{
			throw new RuntimeException(" 初始化密钥出现异常 ");
		}
	}

	// 解密
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception
	{
		// 还原密钥
		Key k = toKey(key);
		// 实例化
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 初始化，设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}

	// 解密
	public static byte[] decrypt(byte[] data, String key) throws Exception
	{
		return decrypt(data, getKey(key));
	}

	// 解密
	public static byte[] decrypt(String data, String key) throws Exception
	{
		return decrypt(Base64.decodeBase64(data), getKey(key));
	}

	// 加密
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception
	{
		// 还原密钥
		Key k = toKey(key);
		// 实例化
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 初始化，设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}

	// 加密
	public static byte[] encrypt(byte[] data, String key) throws Exception
	{
		return encrypt(data, getKey(key));
	}

	// 生成密钥
	public static byte[] initKey() throws Exception
	{
		// 实例化
		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
		// 初始化192位密钥
		kg.init(192);
		// 生成秘密密钥
		SecretKey secretKey = kg.generateKey();
		// 获得密钥的二进制编码形式
		return secretKey.getEncoded();
	}

	// 初始化密钥
	public static String initKeyString() throws Exception
	{
		return Base64.encodeBase64String(initKey());
	}

	// 获取密钥
	public static byte[] getKey(String key) throws Exception
	{
		return Base64.decodeBase64(key);
	}

	// 摘要处理
	public static String shaHex(byte[] data)
	{
		return DigestUtils.md5Hex(data);
	}

	// 生成摘要
	public static String createDigest(byte[] data, String salt)
	{
		String encodeData = Base64.encodeBase64String(data) + salt;
		return shaHex(encodeData.getBytes());
	}

	// 生成摘要
	public static String createDigest(String data, String salt)
	{
		String encodeData = data + salt;
		return shaHex(encodeData.getBytes());
	}

	// 验证摘要是否相等
	public static boolean validata(byte[] data, String messageDigest)
	{
		return messageDigest.equals(shaHex(data));
	}

	// 验证摘要是否相等
	public static boolean validata(String getDigest, String createDigest)
	{
		boolean bool = false;
		if (getDigest == null || "".equals(getDigest) || createDigest == null || "".equals(createDigest))
		{
			return bool;
		}
		if (getDigest.equals(createDigest))
		{
			bool = true;
		}
		return bool;

	}

}
