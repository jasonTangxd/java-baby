package cn.xxo.day12.string;

/**
 * 子串"nba"在字符串"nbaernbatynbauinbaopnba"出现的次数
 * @author jackli
 *
 */
public class StringTest1 {

	public static void main(String[] args) {
		String max = "nbaernbatynbauinbaopnba";
		String min = "nba"; 
		System.out.println(testCount2(max, min));
	}
	
	public static int testCount1(String max, String min) {
		int count = 0;
		int index = 0;
		while((index = max.indexOf(min, index)) != -1) {
			index++;
			count++;
		}
		return count;
	} 

	public static int testCount2(String max, String min) {
		int count = 0;
		int index = 0;
		while((index = max.indexOf(min)) != -1) {
//			index++;
			max = max.substring(++index);
			count++;
		}
		return count;
	} 

}
