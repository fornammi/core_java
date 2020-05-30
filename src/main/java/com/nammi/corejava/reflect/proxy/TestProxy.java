package com.nammi.corejava.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
	public static void main(String[] args) throws InterruptedException {
		final IAnimal animal = new Dog();
		Object proxyObj = Proxy.newProxyInstance(animal.getClass().getClassLoader(),
				animal.getClass().getInterfaces(), 
				new InvocationHandler(){//当方法被调用了，作出处理
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						try {
							System.out.println("被拦截的方法："+method.getName());
							return method.invoke(animal, args);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
							return null;
						}catch (IllegalAccessException e) {
							e.printStackTrace();
							return null;
						}catch (InvocationTargetException e) {
							e.printStackTrace();
							return null;
						}
					}
				}
		);
		
		if(proxyObj instanceof IAnimal){
			System.out.println("the proxyObj is an animal!");
		}else{
			System.out.println("ths proxyObj isn't an animal!");
		}
		
		if(proxyObj instanceof Dog){
			System.out.println("the proxyObj is a dog!");
		}else{
			System.out.println("ths proxyObj isn't a dog!");
		}
		
		IAnimal animalProxy = (IAnimal)proxyObj;
		animalProxy.info();
		animalProxy.hashCode();
		System.out.println(animalProxy.getClass().getName().toString());
	}
}
