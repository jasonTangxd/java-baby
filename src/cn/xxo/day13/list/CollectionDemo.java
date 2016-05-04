package cn.xxo.day13.list;

/**
 * 集合体系：
 * 	   怎么来的？对各个容器不断向上抽取产生的一个体系框架
 * 集合和数组的区别？
 * 	集合的长度是可变的，集合可以存储多种类型的对象
 * 创建集合对象的时候要使用具体的子类。
 * 	抽取的过程中形成顶级父类是抽象，是接口；子类可以提供更加丰富的方法。
 * 
 *
 */
import java.util.*;

public class CollectionDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Collection con1 = new ArrayList();//多态
		//添加
		con1.add("郭飞飞");
		con1.add("陈肖肖");
		con1.add("桑甲存");
		con1.add("王通");
		Iterator it = con1.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			String str = (String)obj;
			if(str.equalsIgnoreCase("桑甲存")) {
				System.out.println(str + ",你好帅，么么哒~");
				/**
				 * 这里抛出了java.util.ConcurrentModificationException并发修改异常，
				 * 也就是说当我们使用迭代器来迭代集合中的元素是，我们不是使用集合的api
				 * 来进行修改元素
				 */
//				con1.add("张多成");
				it.remove();
			}
//			System.out.println(it.next());
		}
		System.out.println(con1);
	}

	/**
	 * 
	 */
	/**
	 * 使用迭代器获取集合中的元素
	 */
	public static void method_get() {
		Collection con1 = new ArrayList();//多态
		//添加
		con1.add("郭飞飞");
		con1.add("陈肖肖");
		con1.add("桑甲存");
		con1.add("王通");
		//获取集合中的元素
//		System.out.println(con1);
		Iterator it = con1.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			String str = (String)obj;
			if(str.equalsIgnoreCase("桑甲存")) {
				System.out.println(str + ",你好帅，么么哒~");
			}
//			System.out.println(it.next());
		}
		
		for(Iterator it1 = con1.iterator(); it1.hasNext();) {
			Object obj = it1.next();
			System.out.println(obj);
		}
	}
	public static void method_2() {
		Collection con1 = new ArrayList();//多态
		//添加
		con1.add("刘俊斌");
		con1.add("许达");
		con1.add("李祖琰");
		con1.add("张宝光女");
		
		Collection con2 = new ArrayList();//多态
		//添加
		con2.add("刘俊斌");
		con2.add("许达");
		con2.add("檀剑");
		con2.add("周杰");		
	
		System.out.println("原集合：" + con1);
		//addAll添加一个集合
//		con1.addAll(con2);
		//retainAll() 取两个集合的交集
//		con1.retainAll(con2);
		//removeAll
		con1.retainAll(con2);
		System.out.println("修改后：" + con1);
	}
	public static void method_1() {
		Collection con = new ArrayList();//多态
		//添加
		con.add("刘俊斌");
		con.add("许达");
		con.add("李祖琰");
		con.add("张宝光女");
		//获取集合长度
		System.out.println(con.size());
		System.out.println("原集合：" + con);
		//判断
		boolean b = con.contains("张宝光女");
		System.out.println(b);
		//删除
//		con.remove("张宝光女");
		con.clear();
		System.out.println("修改后的集合：" + con);
		System.out.println(con.size());
		//
	}
}
