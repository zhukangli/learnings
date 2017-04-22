package com.conley.createType.singleton;
//��������1.6�����ϰ桶Effective Java�����Ƽ��ķ�ʽ��
public class Singleton5 {
	//��̬�ڲ���
	private static class SingletonHolder {
		//����������getInstanceʱ��Ż����
		//��Ϊ�������private�ģ����Կ���new Singleton5();
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	private Singleton5 (){}
	public static final Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
