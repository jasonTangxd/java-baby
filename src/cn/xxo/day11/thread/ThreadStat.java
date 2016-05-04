package cn.xxo.day11.thread;

public class ThreadStat {

	public static void main(String[] args) {
		
		
		new ThreadStat().test();
		
	}

	private void test() {
		// TODO Auto-generated method stub
		//创建一个新的线程
		Thread thread=new Thread(new Hello());
		//此时的状态 NEW
		System.out.println(thread.getState().name());
		
		thread.start();
		//start之后为就绪状态然后由cpu分配资源变为RUNNABLE
		System.out.println(thread.getState().name());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TIMED_WAITING
		System.out.println(thread.getState().name());
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TERMINATED
		System.out.println(thread.getState().name());
		
		
	}
	
	
	/**
	 * 多线程类
	 * @author zenith
	 *
	 */
	class Hello implements Runnable{

		@Override
		public void run() {
			
			

				
				try {
					//TIMED_WAITING
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ssss");
				
			
		}
		
		
		
	}
	
	
}
