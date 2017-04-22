package com.conley.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsLearning {
	public static void main(String[] args) {
		ExecutorService ThreadPool = Executors.newFixedThreadPool(3);//固定线程池
		Executors.newCachedThreadPool();//可以自动扩充的线程池
		Executors.newSingleThreadExecutor();//保证只有一个线程
		Executors.newScheduledThreadPool(3).schedule(new Runnable(){
			@Override
			public void run() {
				System.out.println(111);
				
			}
		}, 2, TimeUnit.SECONDS);//定时器线程池，可以
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				System.out.println(222);
				
			}
		}, 2,2, TimeUnit.SECONDS);//定时器线程池，可以
	}
}
