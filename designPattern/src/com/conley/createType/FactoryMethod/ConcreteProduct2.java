package com.conley.createType.FactoryMethod;

public class ConcreteProduct2 implements Product{
	
	private String name;
	
	private int size;
	
	private String color;
	
	private String owner;
	
	public ConcreteProduct2(String name ,int size,String color,String owner){
		this.name =name;
		this.size=size;
		this.color =color;
		this.owner=owner;
	}

	@Override
	public void show() {
		System.out.println("²úÆ·2:"+name+size+color+owner);
		
	}

}
