package com.conley.createType.singleton;

/**
 * ��˫�ؼ�顱Double-Check
 * @author zhukangli
 *
 */
public class Singleton3 {
	//singleton = new Singleton()��䣬����
	//1���� singleton �����ڴ�
	//2������ Singleton �Ĺ��캯������ʼ����Ա�������γ�ʵ��
	//3����singleton����ָ�������ڴ�ռ䣨ִ�����ⲽ singleton���Ƿ� null �ˣ�
	//������ JVM �ļ�ʱ�������д���ָ����������Ż���Ҳ����˵����ĵڶ����͵�������˳���ǲ��ܱ�֤�ģ����յ�ִ��˳������� 1-2-3 Ҳ������ 1-3-2��
	//����Ǻ��ߣ����� 3 ִ����ϡ�2 δִ��֮ǰ�����̶߳���ռ�ˣ���ʱ instance �Ѿ��Ƿ� null �ˣ���ȴû�г�ʼ������
	//�����̶߳���ֱ�ӷ��� instance��Ȼ��ʹ�ã�Ȼ��˳����µر���
	
	//�����votile���ǽ����������
	private volatile  static Singleton3 singleton = null;
	private Singleton3()  {    }
	public static Singleton3 getInstance() {
		//��һ��������˵�����ʵ�������ˣ��ǾͲ���Ҫͬ���ˣ�ֱ�ӷ��ؾͺ��ˡ�
		if (singleton== null)  {
			synchronized (Singleton3.class) {
				//��Ȼ�����ǾͿ�ʼͬ���̡߳�
				if (singleton== null)  {
					//�ڶ���������˵�������ͬ�����߳��У���һ���̴߳����˶�����ô����߳̾Ͳ����ٴ����ˡ�
					singleton= new Singleton3();
				}
			}
		}
		return singleton;
	}
}
