package com.nammi.algorithm.eg;

public class AlgoTest {
	
	public static void main(String[] args) {
		//first5Devision();
		getPrime();
	}
	
	//输出1~100内前五个可以被3整除的数
	public static void first5Devision(){
		int count = 0;
		for(int i=1; i<=100; i++){
			if(i%3==0){
				System.out.println(i+" ");
				count ++;
			}
			if(count==5){
				break;
			}
		}
	}
	
	//输出101~200内的质数
	public static void getPrime(){
		for(int i=101; i<=200; i++){
			boolean isPrime = true;
			for(int j=2; j<i; j++){
				if(i%j==0){
					isPrime = false;
					break;
				}
			}
			if(!isPrime){
				continue;
			}
			System.out.println(i+" ");
		}
	}
	
	
}
