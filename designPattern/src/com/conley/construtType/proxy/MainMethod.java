package com.conley.construtType.proxy;

public class MainMethod {
	//测试类  
	public static void main(String[] args)  
	{  
		//引用变量定义为抽象角色类型  
		Business bi = new BusinessImplProxy();  
		bi.doAction();  
	}  
}
