package com.conley.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionComunication {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0 ;i<5;i++){
					business.main(i);
				}
			}
		}).start();
		for(int i=0 ;i<5;i++){
			business.sub(i);
		}
	}


	static class Business{
		private  boolean flag = false;
		public Business(){
			lock = new ReentrantLock();
			//�ڵ�ǰ�̻߳�õ��������һ��ʵ��
			condition = lock.newCondition();
		}
		private final Lock lock ;
		private final Condition condition  ;
		public void main(int j){
			lock.lock();
			try{
				while(!flag){
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("main"+i + "��"+j+"��ѭ��");
				}
				flag=false;
				condition.signal();
			}finally{
				lock.unlock();
			}
		}

		public void sub(int j ){
			lock.lock();
			try{
				while(flag){
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("sub"+i+ "��"+j+"��ѭ��");
				}	
				flag=true;
				//Wakes up a single thread that is waiting on this object's monitor.
				condition.signal();

			}finally{
				lock.unlock();
			}
		}
	}
}
