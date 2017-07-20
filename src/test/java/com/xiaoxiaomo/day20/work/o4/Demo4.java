package com.xiaoxiaomo.day20.work.o4;

public class Demo4 {
	public static void main(String[] args) {
		Student s1 = new Student("s1", "张1", "男", 18, 80);
		Student s2 = new Student("s2", "张2", "男", 18, 90);
		Student s3 = new Student("s3", "张3", "男", 18, 59);
		Student s4 = new Student("s4", "张4", "男", 18, 60);
		Student s5 = new Student("s5", "张5", "男", 18, 79);
		
		
		//获取java的平均值
		double avg = (s1.getsJava()+s2.getsJava()+s3.getsJava()+s4.getsJava()+s5.getsJava())/5;
		System.out.println("平均数："+avg);
		
		double[] douarr = {s1.getsJava(),s2.getsJava(),s3.getsJava(),s4.getsJava(),s5.getsJava()};
		
		double max = getMax(douarr);
		double min = getMin(douarr);
		System.out.println("最大值："+max);
		System.out.println("最小值："+min);
	}

	/**
	 * 获取double类型数组中的最大值
	 * @param douarr
	 * @return
	 */
	private static double getMax(double[] douarr) {
		double max = douarr[0];
		for (int i = 1; i < douarr.length; i++) {
			if(max<douarr[i]){
				max = douarr[i];
			}
		}
		
		return max;
	}
	
	
	/**
	 * 获取double类型数组中的最小值
	 * @param douarr
	 * @return
	 */
	private static double getMin(double[] douarr) {
		double min = douarr[0];
		for (int i = 1; i < douarr.length; i++) {
			if(min>douarr[i]){
				min = douarr[i];
			}
		}
		return min;
	}
}
