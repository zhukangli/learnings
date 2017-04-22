package com.conley.createType.FactoryMethod;

public class ConcreteFactory2 implements Factory{

	@Override
	public Product create() {
		return new ConcreteProduct2("固定电话",12,"金色","政府所有");
	}

}
