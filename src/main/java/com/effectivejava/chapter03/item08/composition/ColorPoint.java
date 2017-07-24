// Adds a value component without violating the equals contract - Page 40
package com.effectivejava.chapter03.item08.composition;

public class ColorPoint {
	private final Point point;
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		if (color == null)
			throw new NullPointerException();
		point = new Point(x, y);
		this.color = color;
	}

	/**
	 * Returns the point-view of this color point.
	 */
	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint) o;
		return cp.point.equals(point) && cp.color.equals(color);
	}

	@Override
	public int hashCode() {
		return point.hashCode() * 33 + color.hashCode();
	}
}

//高质量equals方法：
//		1、使用==操作符检查“参数是否为这个对象的引用”。
//		2、使用instanceof操作符检查“参数是否为正确的类型”。
//		3、把参数转换成正确的类型。
//		4、对于该类的每个“关键（significant）”域，检查参数中的域是否与该对象中对应的域相匹配。
//		这点myeclipse自动生成的并不完全完美，myeclipse生成如下：
//		else if (!name.equals(other.name))
//		return false;
//		但是，这条是要求你改成：
//		else if (name != other.name && !name.equals(other.name))
//		return false;
//		5、当你编写完成了equals方法之后，应该会问自己三个问题：他是否的对称的、传递的、一致的。
//		（覆盖equals时总要覆盖hashcode；不要企图让equals方法过于智能；不要将equals声明中的Object对象替换为其他的类型。）
//
//
//		尽量不要省略@Override。