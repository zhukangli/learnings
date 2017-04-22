package com.conley.construtType.adaptor;

public class Mainmethod {

	public static void main(String[] args) {
		//ÀàÊÊÅäÆ÷
		Target adapter = new Adapter();
		adapter.request();
		
		//¶ÔÏóÊÊÅäÆ÷
		Adaptee adaptee = new Adaptee();
		Target adapter1 = new Adapter1(adaptee);
		adapter1.request();
	}

}
