package com.nammi.corejava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAReflection {
	public static void main(String[] args) {
		TestA testA = new TestA();
		Class cla = testA.getClass();
		System.out.println("=====属性=====");
		showFields(cla);
		System.out.println("=====构造方法=====");
		showConstruct(cla);
		System.out.println("=====父类和接口=====");
		showInterfaceNames(cla);
		System.out.println("=====方法=====");
		showMethod(cla);
	}
	
	public static void showFields(Class cla){
		System.out.println("-----所有属性-----");
		Field[] fall = cla.getDeclaredFields();
		for(int i=0; i<fall.length; i++){
			String fname = fall[i].getName();
			Class call = fall[i].getType();
			System.out.println("属性名："+fname+" || 类型： "+call);
		}
		
		System.out.println("-----所有公共属性-----");
		Field[] fpublic = cla.getFields();
		for(int i=0; i<fpublic.length; i++){
			String fname = fpublic[i].getName();
			Class cpublic = fpublic[i].getType();
			System.out.println("属性名："+fname+" || 类型："+cpublic);
		}
		
		System.out.println("-----私有属性-----");
		Field fp1;
		try {
			fp1 = cla.getDeclaredField("a");
			//访问检查：true去掉，false强制--待验证，没看出差别
			fp1.setAccessible(false);
			String fp1name = fp1.getName();
			Class cp1 = fp1.getType();
			System.out.println("属性名："+fp1name+" || 类型："+cp1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showConstruct(Class cla){
		String cname = cla.getName();
		Constructor[] cons = cla.getConstructors();
		for(int i=0; i<cons.length; i++){
			Class[] paramTypes = cons[i].getParameterTypes();
			System.out.print(cname+"(");
			for(int j=0; j<paramTypes.length;j++){
				if(j==0){
					System.out.print(paramTypes[j].getName());
				}
				System.out.print(", "+paramTypes[j].getName());
			}
			System.out.print(")");
			System.out.println("");
		}
	}
	
	public static void showInterfaceNames(Class cla){
		System.out.println("-----父类-----");
		Class superClass = cla.getSuperclass();
		System.out.println(superClass.getName());
		System.out.println("-----接口-----");
		Class[] allInter = cla.getInterfaces();
		for(int i=0; i<allInter.length; i++){
			System.out.println(allInter[i].getName());
		}
	}
	
	public static void showMethod(Class cla){
		Method[] allMethod = cla.getMethods();
		for(int i=0; i<allMethod.length; i++){
			Method m = allMethod[i];
			//返回类型
			System.out.print(m.getReturnType().getName());
			//方法名
			System.out.print(" "+m.getName()+"(");
			//方法参数
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0; j<paramTypes.length; j++){
				if(j==0){
					System.out.print(paramTypes[j].getName());
				}
				System.out.print(", "+paramTypes[j].getName());
			}
			System.out.println(")");
		}
	}
}
