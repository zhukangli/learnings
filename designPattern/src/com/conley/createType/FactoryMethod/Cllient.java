package com.conley.createType.FactoryMethod;

public class Cllient {
	public static void main(String[] args) {
		/**
		 * ���ù���
		 */
		Product pr1 = new ConcreteProduct1("�ֻ�",12,"��ɫ");
		Product pr2 = new ConcreteProduct2("�̶��绰",12,"��ɫ","��������");
		
		pr1.show();
		pr2.show();
		
		/**
		 * �ù����������Կ������β�Ʒ����ϸ��
		 */
		Factory factory1 =new ConcreteFactory1();
		Product p1 = factory1.create();
	
		Factory factory2 =new ConcreteFactory2();
		Product p2 = factory2.create();
		
		p1.show();
		p2.show();
	}
	
}
