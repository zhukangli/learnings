package com.conley.construtType.adaptor;

public class Adapter extends Adaptee implements Target{

	@Override
	public void request() {
		super.specificRequest();
		
	}

}
