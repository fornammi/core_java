package com.nammi.corejava.base.annotation;

/**
 * 要使用SayHiAnnotation的元素所在类
 * 由于定义了只有方法才能使用自定义注解，我们就使用多个方法来进行测试
 * @author daniel.fang
 *
 */
public class MyAnnotationElement {
	
	// 普通的方法
	public void myNomal(String name){
		System.out.println("Hi, "+name);
	}
	
	// 使用注解，并使用参数默认值的方法
	@MyAnnotation
	public void myAnnotationDefault(String name){
		System.out.println("Hi, "+name);
	}
	
	// 使用注解，并传入参数值的方法
	@MyAnnotation(paramValue = "new nammi")
	public void myAnnotation(String name){
		System.out.println("Hi, "+name);
	}
	
}
