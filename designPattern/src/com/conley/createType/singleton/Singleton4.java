package com.conley.createType.singleton;

public class Singleton4 {
	//��ǰ��ʼ���������в�������
	private volatile static Singleton4 singleton = new Singleton4();
	private Singleton4()  {    }
	public static Singleton4 getInstance()   {
		return singleton;
	}
}
