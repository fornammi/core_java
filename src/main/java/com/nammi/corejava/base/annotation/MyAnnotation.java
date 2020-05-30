package com.nammi.corejava.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用来配置方法
 * @author daniel.fang
 *
 */
@Retention(RetentionPolicy.RUNTIME)// 表示注解在运行时依然存在
@Target(ElementType.METHOD)// 表示注解可以被使用于方法上
public @interface MyAnnotation {
	String paramValue() default "nammi";// 表示自定义注解需要一个参数，名为"paramValue"，默认值为"nammi"
}
