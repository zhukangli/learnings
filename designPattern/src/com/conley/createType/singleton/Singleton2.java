package com.conley.createType.singleton;
/**
 * ����ģʽ
 * @author zhukangli
 *
 */
public class Singleton2 {
	private static Singleton2 instance = null;   
	private Singleton2(){   
	} 
	//���ﲻ���������߳�����������ɶ������
	public static Singleton2 getInstance(){   
		if(instance==null){
			instance = new Singleton2();   
		}   return instance;   
	}   
}
