package com.conley.construtType.flyweight;

public class Client {
	public static void main(String[] args) {
		/**
		 * 擦，这个享元模式，不就是把对象找个缓存存起来而已嘛！！！
		 * String类型，也是这样，就在JVM开辟一个地方，方法区的常量池，存起来而已，所以他才需要时final的。
		 * 
		 */
		FlyWeightFactory factory = new FlyWeightFactory();
		FlyWeight flyWeight = factory.factory("a");
		FlyWeight flyWeight2 = factory.factory("b");
		FlyWeight flyWeight3 = factory.factory("a");
		flyWeight.operation("a fly weight");
		flyWeight2.operation("b fly weight");
		flyWeight3.operation("c fly weight");
		System.out.println(flyWeight == flyWeight3);
		System.out.println(factory.getFlyWeightSize());
	}
}
