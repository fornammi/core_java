package com.nammi.corejava.base.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotionOperator {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
	InvocationTargetException, ClassNotFoundException {
		// 初始化一个实例，用于方法调用
		MyAnnotationElement elememt = new MyAnnotationElement();
		// 获得所有方法
		Method[] methods = MyAnnotationElement.class.getDeclaredMethods();
		
		for(Method method : methods){
			MyAnnotation temp = null;
			// 检测是否使用了自定义注解
			if((temp = method.getAnnotation(MyAnnotation.class)) != null){
				// 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
				method.invoke(elememt, temp.paramValue());
			}else{
				// 如果没有使用我们的注解，我们就需要使用普通的方式来调用方法
				method.invoke(elememt, "normal method");
			}
		}
	}
}
