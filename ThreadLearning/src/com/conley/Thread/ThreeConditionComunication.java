package com.conley.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeConditionComunication {
	public static void main(String[] args) {
		final Business business = new Business();

		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0 ;i<5;i++){
					business.B(i);
				}
			}
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0 ;i<5;i++){
					business.C(i);
				}
			}
		}).start();
		Thread A = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0 ;i<5;i++){
					business.A(i);
				}
			}
		});
		A.setPriority(10);
		A.start();
	}


	static class Business{
		private  int flag ;
		public Business(){
			lock = new ReentrantLock();
			conditionA = lock.newCondition();
			conditionB = lock.newCondition();
			conditionC = lock.newCondition();
		}
		private final Lock lock ;
		private final Condition conditionA  ;
		private final Condition conditionB  ;
		private final Condition conditionC  ;
		public void A(int j){
			lock.lock();
			try{
				while(flag!=0){
					try {
						conditionA.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("A线程"+i + "第"+j+"次循环");
				}
				flag=1;
				conditionB.signal();
			}finally{
				lock.unlock();
			}
		}

		public void B(int j ){
			lock.lock();
			try{
				while(flag!=1){
					try {
						conditionB.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("B线程"+i+ "第"+j+"次循环");
				}	
				flag=2;
				//Wakes up a single thread that is waiting on this object's monitor.
				conditionC.signal();

			}finally{
				lock.unlock();
			}
		}
		
		public void C(int j ){
			lock.lock();
			try{
				while(flag!=2){
					try {
						conditionC.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("C线程"+i+ "第"+j+"次循环");
				}	
				flag=0;
				//Wakes up a single thread that is waiting on this object's monitor.
				conditionA.signal();

			}finally{
				lock.unlock();
			}
		}
	}
}
