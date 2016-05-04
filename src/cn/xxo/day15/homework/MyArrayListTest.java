package cn.xxo.day15.homework;

public class MyArrayListTest {
	public static void main(String[] args) {
		MyArrayList<String> mal = new MyArrayList<String>();
		System.out.println(mal.isEmpty());
		mal.add("zhangsan");
		mal.add("lisi");
		mal.add("wangwu");
		mal.add("zhaoliu");
		mal.add("zhouqi");
		System.out.println(mal);
		System.out.println(mal.size());
		System.out.println(mal.get(3));
		System.out.println(mal.remove(1));
		System.out.println(mal);
		System.out.println(mal.size());
	}

}
