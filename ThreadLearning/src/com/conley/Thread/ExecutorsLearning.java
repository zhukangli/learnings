package com.conley.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsLearning {
	public static void main(String[] args) {
		ExecutorService ThreadPool = Executors.newFixedThreadPool(3);//�̶��̳߳�
		Executors.newCachedThreadPool();//�����Զ�������̳߳�
		Executors.newSingleThreadExecutor();//��ֻ֤��һ���߳�
		Executors.newScheduledThreadPool(3).schedule(new Runnable(){
			@Override
			public void run() {
				System.out.println(111);
				
			}
		}, 2, TimeUnit.SECONDS);//��ʱ���̳߳أ�����
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				System.out.println(222);
				
			}
		}, 2,2, TimeUnit.SECONDS);//��ʱ���̳߳أ�����
	}
}
