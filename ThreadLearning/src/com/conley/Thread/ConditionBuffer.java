package com.conley.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	
	final Object[] items = new Object[100];
	int putptr,takeptr,count;
	
	public void put(Object obj) throws InterruptedException{
		lock.lock();
		try{
			while(count == items.length){
				notFull.await();
			}	
			items[putptr]=obj;
			if(++putptr==items.length)putptr=0;
			++count;
			notEmpty.signal();
		}finally{
			lock.unlock();
		}
		
		
	}
	
	public Object get() throws InterruptedException{
		lock.lock();
		try{
			while(count == 0){
				notEmpty.await();
			}	
			Object obj = items[takeptr];
			if(++takeptr==items.length)takeptr=0;
			--count;
			notFull.signal();
			return obj;
		}finally{
			lock.unlock();
		}
		
	}
}

