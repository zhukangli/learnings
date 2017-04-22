package com.conley.createType.builder;
/**
 * ����󹤳�������
 * �ڽ�����ģʽ��и�ָ���ߣ���ָ�������������ߣ�
 * �û�����ָ������ϵ�ģ�ָ������ϵ���������õ���Ʒ��
 * ������ģʽ����ǿ��ʵ��һ�ֲַ�����еĽ�����̡�
 * @author zhukangli
 *
 *���û�����ָ���ߣ��͵��Լ�ȥ���죬�����׸���˳��
 *
 */
public class Director {
	private Builder builder; 

	public Director( Builder builder ) { 
		this.builder = builder; 
	} 
	public void construct() { 
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC(); 
	} 
}
