package cn.xxo.day14.treeset;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;


/**
 *Set:是一个无序的元素不可重复的集合 (存入的顺序和取出的顺序，不一定一致)
 *	|--HashSet：底层采用的数据结构是哈希表，如何判断其中元素唯一性呢？
 *				是不是通过元素本身的hashCode返回值，如果hashCode返回值相等？
 *				就要判断元素本身的equals是否返回为true？
 *					true--->不存
 *					false-->存
 *	|--TreeSet：可以对我们Set集合进行排序。
 *			用String做例子，我们发现，这种排序是对字符串进行的自然排序
 *
 */
public class TreeSetDemo {

	public static void main(String[] args) {
//		method_set_string();
		//treeset存入自定义的对象
		/**
		 * 我们发现无法存入自定义的对象，因为我们自定义的对象不能转化为Compareable
		 * ClassCastException: cn.crxy.collection.treeset.BeautifulGirl 
		 * cannot be cast to java.lang.Comparable
		 * 也就是说，我们自定义的对象不具备比较性
		 * 如果要让我们自定义的对象存入TreeSet，那就必须要让自定义的对象实现implements Comparable接口
		 * 那么就必须要覆盖Comparable接口中的唯一方法compareTo(Object)
		 * 要求：
		 * 按照bg的年龄进行比较，当年龄相同的时候再按照bg的姓名进行比较。
		 * 当我们的主要比较条件无法满足比较（分不出大小的时候），我们就需要按照次要条件进行比较了
		 */
		TreeSet tst = new TreeSet();
//		tst.add(new BeautifulGirl("林少华", 18));
//		tst.add(new BeautifulGirl("姚泳", 38));
//		tst.add(new BeautifulGirl("李岳昆", 48));
//		tst.add(new BeautifulGirl("宋士轩", 18));
		tst.add(new BeautifulGirl("zs06", 18));
		tst.add(new BeautifulGirl("zs02", 38));
		tst.add(new BeautifulGirl("zs03", 48));
		tst.add(new BeautifulGirl("zs01", 18));
		sop(tst);
	}
	
	public static void method_set_string() {
		TreeSet treeSet = new TreeSet();
		treeSet.add("Abb");
		treeSet.add("aaa");
		treeSet.add("aba");
		treeSet.add("abdd");
		
		sop(treeSet);
	}
	
	public static void sop(Collection col) {
		Iterator it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class BeautifulGirl implements Comparable{
	private String name;
	private int age;
	public BeautifulGirl() {
	}
	public BeautifulGirl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj == null) {
			throw new RuntimeException("没有对象你比较个锤子~");
		}
		if(!(obj instanceof BeautifulGirl)) {
			throw new RuntimeException("不是同一种类型，你比较个鸟啊~");
		}
		BeautifulGirl ybf = (BeautifulGirl)obj;
		System.out.println(this.name + "------compareTo-----" + ybf);
//		if(this.age - ybf.age > 0) {
//			return 1;
//		} else if(this.age - ybf.age < 0) {
//			return -1;
//		}
		//先决判断条件
		int num = this.age - ybf.age;
		//
		if(num == 0) {
			System.out.println(this.name + "------compareTo1-----" + ybf);
			num = this.name.compareTo(ybf.name);
		}
		return num;
	}
}
