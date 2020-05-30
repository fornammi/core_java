package com.nammi.corejava.base;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		//取键盘输入的验证码
		System.out.println("-----read input from keyboard begin-----");
		Scanner s = new Scanner(System.in);
		System.out.println("请输入验证码：");
		//读取多行
        /*StringBuffer sb = new StringBuffer();
        while (s.hasNext()) {
            String line = s.next();
            //键盘输入"f"作为结束标志
            if ("f".equals(line)) break;
            sb.append(line).append("\n");
        }
        String validCode = sb.toString();*/
		
		//读取单行:输入回车作为分行标志
		String validCode = s.next().trim();
        System.out.println("validCode:"+validCode);
        System.out.println("-----read input from keyboard end-----");
	}
}
