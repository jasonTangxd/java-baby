package cn.xxo.day21;

/**
 * 切割
 * @author lenovo
 *
 */
public class Demo3 {
	
	public static void main(String[] args) {
		String str = "jdhs,jhds,kjlk,lkjkl";
		String[] split = str.split(",");
		for (String string : split) {
			System.out.println(string);
		}
		
		
		str = "a b  c   d";
		String[] split2 = str.split(" +");
		for (String string : split2) {
			System.out.println(string);
		}
		
		
		
		str = "aa.bb.cc.xx.mm";
		String[] split4 = str.split("\\.");
		for (String string : split4) {
			System.out.println(string);
		}
		
		
		//叠词
		str = "abbaaxxcssdjkslsklllnmmmma112";
		String[] split3 = str.split("(.)\\1+");//了解
		for (String string : split3) {
			System.out.println(string);
		}
		
		
	}

}
