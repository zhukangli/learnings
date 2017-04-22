package com.conley.createType.FactoryMethod;

public class Cllient {
	public static void main(String[] args) {
		/**
		 * 不用工厂
		 */
		Product pr1 = new ConcreteProduct1("手机",12,"白色");
		Product pr2 = new ConcreteProduct2("固定电话",12,"金色","政府所有");
		
		pr1.show();
		pr2.show();
		
		/**
		 * 用工厂，很明显可以屏蔽产品构造细节
		 */
		Factory factory1 =new ConcreteFactory1();
		Product p1 = factory1.create();
	
		Factory factory2 =new ConcreteFactory2();
		Product p2 = factory2.create();
		
		p1.show();
		p2.show();
	}
	
}
