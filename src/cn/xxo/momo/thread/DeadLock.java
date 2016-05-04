package cn.xxo.momo.thread;

public class DeadLock {
	
	//水壶
	private Object object1=new Object();
	//水杯
	private Object object2=new Object();
	
	
	public static void main(String[] args) {
		
		new DeadLock().test();
		
		
	}
	
	
	
	private void test() {
		// TODO Auto-generated method stub
		
		//people 1
		Thread th1= new Thread(new Dead(0),"小明");
		//people 2
		Thread th2=new Thread(new Dead(1),"小丽");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	/**
	 * 死锁类
	 * @author zenith
	 *
	 */
	class Dead implements Runnable{
		
		private int tag=0;
		
		public Dead(int _tag) {
			tag=_tag;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			if(tag==0){
				//尝试着拿水壶
				synchronized (object1) {
					System.out.println(Thread.currentThread().getName()+"拿到了水壶");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//尝试着去拿水杯
					System.out.println(Thread.currentThread().getName()+"尝试着拿水杯");
					synchronized (object2) {
							System.out.println(Thread.currentThread().getName()+"也拿到了水杯");
					}
				}
				
			}else{
				
				//尝试着拿水杯
				synchronized (object2) {
					System.out.println(Thread.currentThread().getName()+"拿到了水杯");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//尝试着去拿水壶
					System.out.println(Thread.currentThread().getName()+"尝试着拿水壶");
					synchronized (object1) {
							System.out.println(Thread.currentThread().getName()+"也拿到了水壶");
					}
					
					
				}
				
				
				
			}
			
			
			
			
		}
		
		
		
	}

}
