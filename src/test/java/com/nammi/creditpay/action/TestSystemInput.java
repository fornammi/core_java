package com.nammi.creditpay.action;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Scanner;


public class TestSystemInput {

	public static void main(String[] args) {
		try {

			//获取键盘输入的验证码:模拟手机接收验证码并输入的过程
	        System.out.println("-----read input from keyboard begin-----");
			Scanner s = new Scanner(System.in);
			System.out.println("请输入验证码：");
			//只读一行
	        String validCode = s.nextLine().trim();
	        System.out.println("validCode:"+validCode);
	        System.out.println("-----read input from keyboard end-----");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
