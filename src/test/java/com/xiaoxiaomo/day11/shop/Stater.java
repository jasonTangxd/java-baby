package com.xiaoxiaomo.day11.shop;

public class Stater implements Runnable{
	public Stater(Bags bag) {
		this.bag = bag;
	}

	private Bags bag;
	
	@Override
	public void run() {
			synchronized (bag) {
				//打印店铺总收益
			System.out.println("店铺的总收益："+bag.getOwnTotal());
		}
	}
}
