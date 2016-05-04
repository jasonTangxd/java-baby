package cn.xxo.day11.shop;

import java.util.Random;

public class MeiNv  implements Runnable{

	private Bags bag;

	public MeiNv(Bags bag) {
		this.bag = bag;
	}
	Random random=new Random();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("欢迎光临！！！我是美女 "+Thread.currentThread().getName());
			
			//用户的随机购买数量产生
		Integer bjjToBuy=random.nextInt(3)+1;
		Integer klToBuy=random.nextInt(3)+1;
		
		synchronized (bag) {
			Integer bjjCount=bag.getBjjCount();
			Integer klCount=bag.getKlCount();
			
			//可乐
			if(klToBuy<=klCount){
				bag.setKlCount(klCount-klToBuy);
				bag.setOwnTotal(bag.getOwnTotal()+klToBuy*2);
				System.out.println(String.format("%s卖出了 %s瓶可乐  赚了 %s 块钱",Thread.currentThread().getName(),klToBuy,klToBuy*2));
			}else{
				System.out.println(String.format("%s说：客户要买%s瓶可乐  可是库存不够了呢！！！"
						,Thread.currentThread().getName(),klToBuy));
			}
			
			//冰激淋
			if(bjjToBuy<=bjjCount){
				bag.setBjjCount(bjjCount-bjjToBuy);
				bag.setOwnTotal(bag.getOwnTotal()+bjjToBuy*3);
				System.out.println(String.format("%s卖出了 %s瓶冰激淋  赚了 %s 块钱",Thread.currentThread().getName(),bjjToBuy,bjjToBuy*3));
			}else{
				System.out.println(String.format("%s说：客户要买%s个冰激淋  可是库存不够了呢！！！"
						,Thread.currentThread().getName(),bjjToBuy));
			}
		}
	}
	}
	
}
