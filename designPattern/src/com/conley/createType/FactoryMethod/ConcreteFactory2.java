package com.conley.createType.FactoryMethod;

public class ConcreteFactory2 implements Factory{

	@Override
	public Product create() {
		return new ConcreteProduct2("�̶��绰",12,"��ɫ","��������");
	}

}
