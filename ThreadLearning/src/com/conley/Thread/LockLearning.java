package com.conley.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ËøÑ§Ï°
 * @author Conley
 *
 */
public class LockLearning {
	private static final Object obj = new Object(); 
	private static final Lock lock = new ReentrantLock();
	public void test1(){
		synchronized(obj){
			System.out.println(1);
		}
	}
	
	public void test2(){
		lock.lock();
		try{
			System.out.println(2);
		}catch(Exception e ){
			
		}finally{
			lock.unlock();
		}
	}
}
