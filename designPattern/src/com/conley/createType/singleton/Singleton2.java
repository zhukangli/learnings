package com.conley.createType.singleton;
/**
 * 饿汉模式
 * @author zhukangli
 *
 */
public class Singleton2 {
	private static Singleton2 instance = null;   
	private Singleton2(){   
	} 
	//这里不加锁，多线程情况可能生成多个对象
	public static Singleton2 getInstance(){   
		if(instance==null){
			instance = new Singleton2();   
		}   return instance;   
	}   
}
