package cn.xxo.day14.generic;

/**
 * 自定义泛型
 * 1、在类上定义泛型
 * 
 */
public class GenericDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//第一个版本
		new WorkerFactory().setWorker(new Worker());
		//第一个版本抽取
		ObjectFactory of = new ObjectFactory();
		of.setObject(new Worker());
		Object obj= of.getObject();
		Worker worker = (Worker)obj;
		//第二个版本
		/**
		 * 我们使用了泛型来定义我们未知的类型，我们也看到了使用泛型对我们的代码抽象有非常好的帮助，减少了我们的书写
		 * 将可能在运行阶段出现的异常转化到了编译阶段
		 * 避免了在代码执行过程中的强制类型转化动作
		 */
		ObjectExtendedFactory<handsameBoy> oef = new ObjectExtendedFactory<handsameBoy>();
		oef.setObject(new handsameBoy());
		handsameBoy hsb = oef.getObject();
		
	}

}
/**
 * 第一个版本，没有泛型
 * 第二个版本，使用泛型
 * 	如何在我们类上来定义一个泛型
 */

class ObjectExtendedFactory<Ttttttt> {
	Ttttttt t;
	public void setObject(Ttttttt t) {
		this.t = t;
	}
	public Ttttttt getObject() {
		return t;
	}
}


class handsameBoy {
	
}

class Worker {
	public void produce() {
		System.out.println("shuaige");
	}
}

class ObjectFactory {
	private Object obj;
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	public Object getObject() {
		return obj;
	}
}
//第一个版本
class WorkerFactory {
	private Worker worker;
	
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Worker getWorker() {
		return worker;
	}
}
