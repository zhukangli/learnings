package com.conley.createType.FactoryMethod;

public class ConcreteProduct1 implements Product{
	private String name;
	
	private int size;
	
	private String color;
	
	public ConcreteProduct1(String name ,int size,String color){
		this.name =name;
		this.size=size;
		this.color =color;
	}

	@Override
	public void show() {
		System.out.println("²úÆ·1:"+name+size+color);
		
	}

}
