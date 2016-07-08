package com.xxo.day11.thread;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomStatNew {

	Integer total=0;
	
	public static void main(String[] args) {
		
		new RandomStatNew().test();
		
	}

	private void test() {
		
//		ScheduledExecutorService ProducerService= Executors.newScheduledThreadPool(1);
//		ProducerService.scheduleAtFixedRate(new ProducerNew(), 1, 1, TimeUnit.SECONDS);
//		
//		ScheduledExecutorService StatService= Executors.newScheduledThreadPool(1);
//		StatService.scheduleAtFixedRate(new StaterNew(), 11, 10, TimeUnit.SECONDS);
		
		
		ScheduledExecutorService service= Executors.newScheduledThreadPool(2);
		service.scheduleAtFixedRate(new ProducerNew(), 1, 1, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(new StaterNew(), 11, 10, TimeUnit.SECONDS);
	}
	
	//01新建一个多线程类 继承 Thread 类或者实现Runnable接口 
	//02生产者 每秒生产数据加和到一个int变量 total里  1s
	//03新建一个多线程类 负责统计的total、清零该变量   10s
	
	class ProducerNew implements Runnable{

		Random random=new Random();
		@Override
		public void run() {
				int number=random.nextInt(10);
				System.out.println(number);
				total=total+number;
			System.out.println("name:"+Thread.currentThread().getName());
		}
		
	}
	
	class StaterNew implements Runnable{

		@Override
		public void run() {
			
					System.out.println(total);
					total=0;
				System.out.println("name:"+Thread.currentThread().getName());
		}	
	}	
}
