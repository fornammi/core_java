package com.nammi.algorithm.eg;

public class SubSequence {
	/**
	 * 和等于sum的连续自然数
	 * 等差数列求和公式：
	 * 1、项数=（末项-首项）/公差+1
	 * 2、所有项的和=（末项+首项）*项数/2
	 * @param sum
	 */
	public static void getAllSumSeq(long sum){
		boolean isExist = false;
		for(int i=1; i<=sum/2; i++){
			for(int j=i+1; j<sum; j++){
				if(sum*2 == (i+j)*((j-i)/1+1)){
					isExist = true;
					System.out.print(sum+"=");
					for(int k=i; k<=j; k++){
						if(k==i){
							System.out.print(k);
							continue;
						}
						System.out.print("+"+k);
					}
					System.out.println();
					System.out.println("--------------");
				}
			}
		}
		if(!isExist){
			System.out.println("没有和等于"+sum+"的连续自然数序列");
		}
	}
	
	public static void main(String[] args) {
		SubSequence.getAllSumSeq(1000);
	}
}
