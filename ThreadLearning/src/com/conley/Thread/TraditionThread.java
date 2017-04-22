package com.conley.Thread;

public class TraditionThread {
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
		public synchronized void main(int j){
			while(!flag){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<10;i++){
				System.out.println("main"+i + "第"+j+"次循环");
			}
			flag=false;
			this.notify();
		}
		
		public synchronized void sub(int j ){
			while(flag){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<10;i++){
				System.out.println("sub"+i+ "第"+j+"次循环");
			}	
			flag=true;
			//Wakes up a single thread that is waiting on this object's monitor.
			this.notify();
		}
		
	}
	
}
