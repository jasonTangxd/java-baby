package cn.xxo.day12.string;

public class StringConstructor {
	
	public static void main(String[] args) {
		cons_char();
	}
	
	public static void cons_char() {
		char[] chs = {'a', 'b', 'c'};
		String str = new String(chs);
		System.out.println(str);
	}
	public static void cons_bytes() {
		byte[] bytes = {97, 98, 99};
		String str = new String(bytes);
		System.out.println(str);
	}
}
