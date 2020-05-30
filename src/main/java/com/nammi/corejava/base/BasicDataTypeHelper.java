package com.nammi.corejava.base;

import java.math.BigDecimal;

public class BasicDataTypeHelper {
	
	public static void main(String[] args) {
		/**
		 * 保留两位小数
		 */
		java.text.DecimalFormat f = new java.text.DecimalFormat("#.##");
		System.out.println("保留两位小数[方式1：DecimalFormat-format]："+f.format(3.1415926));//3.14
		
		java.math.BigDecimal bd = new java.math.BigDecimal("3.1415926");
		System.out.println("保留两位小数[方式2：BigDecimal-setScale]："+bd.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		double d = 3.1415926;
		long l = Math.round(d*100);
		System.out.println("保留两位小数[方式3：Math.round-先乘100后除100.0]："+l/100.0);
		
	}
}
