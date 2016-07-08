package com.xxo.day20.work;

public class Demo2 {
	
	public static void main(String[] args) {
		int jishu = 0;
		int oushu = 0;
		for (int i = 1; i <=100; i++) {
			if(i%2==0){
				oushu+=i;
			}else{
				jishu+=i;
			}
		}
		
		System.out.println("奇数和："+jishu);
		System.out.println("偶数和："+oushu);
		
	}
	
	

}
