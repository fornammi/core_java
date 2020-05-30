package com.nammi.corejava.base;

public class FallThroughTest {
	//switch case自由穿透问题
	public static void main(String[] args) {
		int i = 2;
		switch (i) {
		case 1:
			System.out.println("woshishuaige1");
			break;
		case 2:
			System.out.println("woshishuaige2");
			break;
		case 3:
			System.out.println("woshishuaige3");
			break;
		default:
			System.out.println("xiaosile");
		}
		switch (i) {
		case 1:
			System.out.println("我是帅哥1");
		case 2:
			System.out.println("我是帅哥2");
		case 3:
			System.out.println("我是帅哥3");
		default:
			System.out.println("笑死了");
		}
	}
}
