package com.conley.createType.FactoryMethod;

public class ConcreteFactory1 implements Factory{

	@Override
	public Product create() {
		return new ConcreteProduct1("�ֻ�",12,"��ɫ");
	}
}