package cn.xxo.day20.work;

public class Demo8 {
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("原始数组：");
		printArr(arr);
		System.out.println("换位之后的数组");
		int[][] arr2 = new int[3][3];
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 3; j++) {
				arr2[j][i] = arr[i][j];
			}
		}
		printArr(arr2);
		
		
	}

	/**
	 * 打印二维数组
	 * @param arr
	 */
	private static void printArr(int[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
