package com.conley.construtType.flyweight;

public class ConcreteFlyWeight implements FlyWeight{
	private String str;// ����״̬
	public ConcreteFlyWeight(String str) {
		this.str = str;
	}
	@Override
	public void operation(String s) {
		 System.out.println("���̱���:" + str);
		 System.out.println("���̱���:" + s);
	}
}
