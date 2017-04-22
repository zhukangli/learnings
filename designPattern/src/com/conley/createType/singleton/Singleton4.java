package com.conley.createType.singleton;

public class Singleton4 {
	//提前初始化，不会有并发问题
	private volatile static Singleton4 singleton = new Singleton4();
	private Singleton4()  {    }
	public static Singleton4 getInstance()   {
		return singleton;
	}
}
