package com.conley.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {
	private static ThreadLocal<Integer> threadLocal= new ThreadLocal<Integer>();
	private AtomicInteger i = new AtomicInteger(0);
	private static AtomicIntegerMain instance ;
	private AtomicIntegerMain(){};
	public static  synchronized AtomicIntegerMain  getInstance(){
		if(instance==null){
			instance = new AtomicIntegerMain();
		}
		return instance;
	}

	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			new A().start();
			new B().start();			
		}
	}


	static class A extends Thread{
		@Override
		public void run() {
			//int i=AtomicIntegerMain.getInstance().i.incrementAndGet();
			//threadLocal.set(i);
			//System.out.println("线程A,的数值为"+i);
			System.out.println("A"+AtomicIntegerMain.getInstance().i.incrementAndGet());
		};

	}

	static class B extends Thread{
		@Override
		public void run() {
			//int i=AtomicIntegerMain.getInstance().i.decrementAndGet();
			//threadLocal.set(i);
//			System.out.println("线程B,的数值为"+i);
			System.out.println("B"+AtomicIntegerMain.getInstance().i.decrementAndGet());
		};
	}



}
