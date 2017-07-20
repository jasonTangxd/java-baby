package com.xiaoxiaomo.day20.work;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] split = line.split(" ");
		
		int[] arr = new int[split.length];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(split[i]);
		}
		
		printArr(arr);
		swap(arr);
		
		printArr(arr);
		
		
	}

	private static void swap(int[] arr) {
		for (int i = 0; i < 5; i++) {
			int tmp = arr[9-i];
			arr[9-i] = arr[i];
			arr[i] = tmp;
		}
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	

}
