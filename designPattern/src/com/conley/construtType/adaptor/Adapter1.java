package com.conley.construtType.adaptor;

public class Adapter1 implements Target{
	private Adaptee adaptee;
	
	public  Adapter1(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	@Override
	public void request() {
		adaptee.specificRequest();		
	}

}
