package cn.xxo.day11.thread;

import java.util.Random;

public class RandomStat {

	int total=0;
	
	public static void main(String[] args) {
		
		new RandomStat().test();
		
	}

	private void test() {
		// TODO Auto-generated method stub
		
		
//		Thread producer=new Thread(new Producer());
//		producer.setName("producer");
		
		Thread producer=new Thread(new Producer(),"producer");
		producer.setPriority(10);
		producer.start();
		
		
		Thread stater=new Thread(new Stater(), "stater");
		stater.setPriority(9);
		stater.start();
		
		
		
		
	}
	
	//01新建一个多线程类 继承 Thread 类或者实现Runnable接口 
	//02生产者 每秒生产数据加和到一个int变量 total里  1s
	//03新建一个多线程类 负责统计的total、清零该变量   10s
	
	class Producer implements Runnable{

		Random random=new Random();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
				int number=random.nextInt(10);
				System.out.println(number);
				
				total=total+number;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	
	class Stater implements Runnable{

		@Override
		public void run() {
			
			while(true){

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(total);
				total=0;
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	
	
	
}
