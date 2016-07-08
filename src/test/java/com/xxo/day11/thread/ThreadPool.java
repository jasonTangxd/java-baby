package com.xxo.day11.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	
	public static void main(String[] args) {
		
		//单线程池
//		ExecutorService executorService= Executors.newSingleThreadExecutor();
//		executorService.submit(new SayHello());
//		executorService.submit(new SayHello());
//		executorService.submit(new SayHello());
		
//		固定大小的线程池
//		ExecutorService executorServiceFixed=Executors.newFixedThreadPool(4);
//		executorServiceFixed.submit(new SayHello());
//		executorServiceFixed.submit(new SayHello());
//		executorServiceFixed.submit(new SayHello());
		//executorService.shutdown();
		//可变的（缓存）线程池
//		ExecutorService executorServiceCache=Executors.newCachedThreadPool();
//		executorServiceCache.submit(new SayHello());
//		executorServiceCache.submit(new SayHello());
//		executorServiceCache.submit(new SayHello());
//		executorServiceCache.submit(new SayHello());
	//周期性线程池
		
		 ScheduledExecutorService  scheduledExecutorService= Executors.newScheduledThreadPool(3);
		 //延迟的调用
		 //scheduledExecutorService.schedule(new SayHello(), 2, TimeUnit.SECONDS);
		 //System.out.println(new Date());
		 
		 //固定延时的线程池。
		 //long initialDelay 初始化的延迟时间：提交任务X(TimeUnit)后开始执行此任务。
		 //long delay 周期性的延迟时间：执行完成一个任务后的X(TimeUnit)后再执行下一个任务，时间间隔是以完成任务时的时间点。
		 //本次任务完成的时间点+delay(TimeUnit)=下次任务开始的时间。
		 //scheduledExecutorService.scheduleWithFixedDelay(new SayHello(), 2, 4, TimeUnit.SECONDS);
		 //System.out.println(new Date());
		 
		 //固定执行间隔的线程池
		 //long delay 周期性的执行时间：开始执行一个任务后的X(TimeUnit)后再执行下一个任务，时间间隔是以开始任务时的时间点。
		 //本次任务开始的时间点+delay(TimeUnit)=下次任务开始的时间。但是：如果delay小于执行任务的执行时间的时候，第二个任务会在第一个任务完成后开始。
		 scheduledExecutorService.scheduleAtFixedRate(new SayHello(), 3, 4, TimeUnit.SECONDS);
		 System.out.println(new Date());
		 
		 
		
		
	}
	
	
	
	
}
/**
 * 多线程的类
 * @author xiaoxiaomo
 *
 */
class SayHello implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"hello begin"+new Date());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"hello end"+new Date());
		//TODO 调用接口 并发数 低于5
	
		
	}
	
	
	
}