package cn.xxo.day13.set;

public class StringHashVal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("java01" + Integer.toHexString("java01".hashCode()));
		System.out.println("java02" + Integer.toHexString("java02".hashCode()));
		System.out.println(Integer.toHexString("java03".hashCode()));
	}

}
