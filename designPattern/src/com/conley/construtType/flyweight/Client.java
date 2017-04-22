package com.conley.construtType.flyweight;

public class Client {
	public static void main(String[] args) {
		/**
		 * ���������Ԫģʽ�������ǰѶ����Ҹ�������������������
		 * String���ͣ�Ҳ������������JVM����һ���ط����������ĳ����أ����������ѣ�����������Ҫʱfinal�ġ�
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
