package cn.xxo.day15.jdknew;

/**
 * 可变参数
 * 使用可变参数的时候，必须要把可变参数放到我们参数列表的最后面
 */
public class DynamicParamDemo {

	public static void main(String[] args) {
//		add(1, 2, 3);
//		add(1, 2, 3, 4);
//		add(1, 2);
//		int[] arr = {1, 2, 3};
//		add(arr);
//		int[] arr1 = {1, 2, 3, 4};
//		add(arr1);	
		System.out.println(add1(1, 2, 3));
		System.out.println(add1("aaa", 1, 2, 3, 4));
	}
	
	public static int add(int x, int y) {
		return x + y;
	}
	public static int add(int x, int y, int z) {
		return x + y + z;
	}
	public static int add(int x, int y, int z, int w) {
		return x + y + z + w;
	}
	
	public static int add(int[] arr) {
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		return sum;
	}
	
	public static int add1(int... arr) {
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		return sum;
	}
	
	public static int add1(String str, int... arr) {
		System.out.println(str);
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		return sum;
	}

	/*
	 * 这个是编译不通过的，因为可变参数必须要放到我们参数列表的最后面，便于我们对参数进行解析
	public static int add1(int... arr, String str) {
		System.out.println(str);
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		return sum;
	}*/
}
