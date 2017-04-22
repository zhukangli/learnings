package com.conley.Thread;

public class Singleton {
	private static class SingletonHolder{
		private static final Singleton singleton = new Singleton();
	}
	private Singleton(){}
	public static final Singleton getInstance(){
		return SingletonHolder.singleton;
		
	}
	
	
	enum Singleton2{
		/**
		 * 这里其实调用了1次，new Enum<Singleton2>("INTANCE",0); 
		 * 编译之后是
		 * public static final  Singleton2 INTANCE;
		 */
		I;
	}
	

	

}
