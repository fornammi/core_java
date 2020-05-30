package com.nammi.net;

import java.security.MessageDigest;

public class MD5Utils {
	public static void main(String[] args) {
		String test = "123456";//[B@1fb8ee3
		String md5Str = string2MD5(test);
		System.out.println("["+test+"]'s hex MD5 is ["+md5Str+"]");
	}
	
	public static String byteArray2Hex(byte[] byteArray){
		char[] hexDigit = {'0','1','2','3','4','5','6','7','8',
				'9','A','B','C','D','E','F'};
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;
		for(byte b : byteArray){
			/**
			 * 在java中以0x开头的数表示十六进制数(如0x1, 0xa)， 其中以字母a~f表示10~15的数字
			 * 在java中以0开头的数表示八进制数(如012,03)，没有前缀的数才表示十进制数(如123,4)
			 */
			resultCharArray[index++] = hexDigit[b>>>4 & 0xf];
			resultCharArray[index++] = hexDigit[b & 0xf];
		}
		return new String(resultCharArray);
	}
	
	public static String string2MD5(String str){
		try{
			// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）  
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 输入的字符串转换成字节数组  
			byte[] strByteArray = str.getBytes();
			
			md.update(strByteArray);
			// 转换并返回结果，也是字节数组，包含16个元素 
			byte[] resultByteArray = md.digest();
			System.out.println("["+str+"]'s MD5 is ["+resultByteArray.toString()+"]");
			// 字符数组转换成字符串返回  
			return byteArray2Hex(resultByteArray);
		}catch(Exception e){
			return null;
		}
	}
}
