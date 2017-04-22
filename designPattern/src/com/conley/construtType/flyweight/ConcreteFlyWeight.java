package com.conley.construtType.flyweight;

public class ConcreteFlyWeight implements FlyWeight{
	private String str;// 内蕴状态
	public ConcreteFlyWeight(String str) {
		this.str = str;
	}
	@Override
	public void operation(String s) {
		 System.out.println("内蕴变量:" + str);
		 System.out.println("外蕴变量:" + s);
	}
}
