package cn.xxo.day11.shop;

public class Producer implements Runnable {

	
	
	public Producer(Bags bag) {
		this.bag = bag;
	}

	private Bags bag;
	
	@Override
	public void run() {
		synchronized (bag) {
			//生产冰激淋和可乐
			bag.setBjjCount(bag.getBjjCount()+5);
			bag.setKlCount(bag.getKlCount()+5);
			System.out.println(String.format("我们入货 冰激淋 5个 可乐5瓶 目前剩余 可乐：%s瓶 冰激淋 %s 个",bag.getKlCount(),bag.getBjjCount()));
		}
	}
	
	
}
