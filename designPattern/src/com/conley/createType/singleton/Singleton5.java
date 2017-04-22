package com.conley.createType.singleton;
//下面的这个1.6版是老版《Effective Java》中推荐的方式。
public class Singleton5 {
	//静态内部类
	private static class SingletonHolder {
		//在真正调用getInstance时候才会调用
		//因为这个类是private的，所以可以new Singleton5();
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	private Singleton5 (){}
	public static final Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
