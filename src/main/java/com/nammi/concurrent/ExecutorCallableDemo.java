package com.nammi.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		//
		for(int i=0; i<10; i++){
			Future<String> future = executorService.submit(new TaskWithResult(i));
			resultList.add(future);
		}
		
		for(Future<String> fs : resultList){
			try{
				while(!fs.isDone());
				System.out.println(fs.get());
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}finally{
				executorService.shutdown();
			}
		}
	}
}

class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	
	public String call() throws Exception{
		System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
		return "call()方法被自动调用，任务返回的结果是：" + id + " " + Thread.currentThread().getName();
	}
}
