package com.conley.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureLearning {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/**
		 * 单一任务返回future
		 */
		Future<String> f = Executors.newSingleThreadExecutor().submit(
				new Callable<String>(){
					public String call() throws Exception {
						Thread.sleep(1900);
						return "hello";
					};
				}
				);

		String i = null;
		try {
			i = f.get(2, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("异常");
			e.printStackTrace();
		}
		System.out.println(i);

		/**
		 * 多个任务返回Future
		 */
		//创建线程池
		ExecutorService ThreadPool = Executors.newFixedThreadPool(10);
		CompletionService<Integer> complete =  new ExecutorCompletionService<Integer>(ThreadPool);
		//提交任务
		for(int j =0 ;j<10;j++){
			final int task = j;
			complete.submit(new Callable<Integer>(){
				@Override
				public Integer call() throws Exception {
					return task;
				}
			});
		}
		//10个任务谁先完成就打印谁
		for(int j =0 ;j<10;j++){
			System.out.println(complete.take().get());
		}
	}
}
