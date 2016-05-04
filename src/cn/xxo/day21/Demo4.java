package cn.xxo.day21;

/**
 * 替换
 * @author lenovo
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		String str = "ajkhsakjkj";
		String replaceAll = str.replaceAll("a", "m");
		//System.out.println(replaceAll);
		
		String replaceAll2 = str.replaceAll("[aj]", "n");
		System.out.println(replaceAll2);
		
		
	}
}
