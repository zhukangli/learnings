package com.conley.createType.singleton;

/**
 * hģʽ,Ԥ�ȼ��أ�
 * @author zhukangli
 *
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();   
	private Singleton1(){}
	public static Singleton1 getInstance(){
		return instance;
	}	
}
