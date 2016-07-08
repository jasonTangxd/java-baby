package com.xxo.day11.thread;

public class ThreadLocalTest {

	private String name;
	private ThreadLocal<String> local=new ThreadLocal<String>();
	
	public static void main(String[] args) {
		
		new ThreadLocalTest().test();
		
	}
	
	
	
	private void test() {
//		new Thread(new Normal()).start();
//		new Thread(new Normal()).start();
		
		new Thread(new SayHelo()).start();
		new Thread(new SayHelo()).start();	
		
	}



	class SayHelo implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			local.set(Thread.currentThread().getName());
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(local.get());		
		}
		
	}

	class Normal implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
			name=Thread.currentThread().getName();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(name);		
		}
		
	}
	
	
}



