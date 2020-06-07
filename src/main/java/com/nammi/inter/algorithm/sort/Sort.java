package com.nammi.inter.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: daniel.fang
 * @create: 2020/6/7 0007 21:39
 **/
public class Sort {

    public static void main(String[] args) {
        int[] a = new int[]{6,2,22,45,1,6,8,200,56,111};
        System.out.println("-----after bubbleSort-----");
        printArrayInLine(bubbleSort(a));

        System.out.println("-----after selectionSort-----");
        printArrayInLine(selectionSort(a));
    }

    /**
     * 将数组元素在一行打印出来，逗号分隔
     * @param a
     */
    public static void printArrayInLine(int[] a) {
        StringBuffer buf = new StringBuffer();
        for (int i=0; i<a.length; i++) {
            if (i > 0) {
                buf.append(",");
            }
            buf.append(a[i]);
        }
        System.out.println(buf.toString());
    }

    /**
     * 冒泡排序
     * @param a
     */
    public static int[] bubbleSort(int[] a) {
        // 第一个for循环：程序需要执行多少趟（len-1趟）
        for (int i=1; i<a.length; i++) {
            // 第二个for循环：每趟需要比较多少次（第一趟len-1次，第二趟len-2次。。。）
            for (int j=0; j<a.length-i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }

    /**
     * 选择排序
     * @param a
     * @return
     */
    public static int[] selectionSort(int[] a) {
        // 第一个for循环：基准的索引
        for (int i=0; i<a.length-1; i++) {
            // 第二个for循环：待排序的元素索引
            for (int j=i+1; j<a.length; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }



}
