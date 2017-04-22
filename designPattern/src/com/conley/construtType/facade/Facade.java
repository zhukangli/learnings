package com.conley.construtType.facade;

public class Facade {
	private ModuleA a =new ModuleA();
	private ModuleB b = new ModuleB();
	private ModuleC c = new ModuleC();
	public Facade(){
		
	}
	public void test(){
		a.b();
		b.d();
		c.f();		
	}
}
