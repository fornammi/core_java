package com.nammi.quiz.corejava;

import java.util.ArrayList;
import java.util.List;

public class ValTransInJava {
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			stuList.add(new Student(i, "value"+i));
		}
		System.out.println("初始list:");
		for(Student s:stuList){
			System.out.println("student.index="+s.getIndex()+" student.value="+s.getValue());
		}
		changeList(stuList);
		System.out.println("修改后list:");
		for(Student s:stuList){
			System.out.println("student.index="+s.getIndex()+" student.value="+s.getValue());
		}
	}
	
	public static void changeList(List<Student> list){
		for(int i=0; i<3; i++){
			//实现赋值的两种方式：
			//list.get(i).setValue("value"+(i+100));
			//用第二个参数所表示的元素，替换索引i处的元素
			list.set(i, new Student(i, "value"+(i+100)));
		}
	}
}
