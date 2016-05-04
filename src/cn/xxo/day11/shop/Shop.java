package cn.xxo.day11.shop;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Shop {

	public static void main(String[] args) {
		
		//初始化店铺物品类
		Bags bag=new Bags(2, 2, 0);
		//生产方启动每10s周期性执行
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Producer(bag), 0, 10, TimeUnit.SECONDS);
		//美女店员上岗
		new Thread(new MeiNv(bag),"lucy").start();
		new Thread(new MeiNv(bag),"rose").start();
		
		//统计脚本启动每分钟周期执行
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Stater(bag), 60, 60, TimeUnit.SECONDS);
	}
	
}
