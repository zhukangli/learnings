package com.conley.construtType.adaptor;

public class Mainmethod {

	public static void main(String[] args) {
		//��������
		Target adapter = new Adapter();
		adapter.request();
		
		//����������
		Adaptee adaptee = new Adaptee();
		Target adapter1 = new Adapter1(adaptee);
		adapter1.request();
	}

}
