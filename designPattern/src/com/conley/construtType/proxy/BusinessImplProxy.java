package com.conley.construtType.proxy;

public class BusinessImplProxy implements Business{

	private BusinessImpl bi;  
	public void doAction()  
	{  
		if (bi==null)  
		{  
			bi = new BusinessImpl();  
		}  
		doBefore();  
		bi.doAction();  
		doAfter();  
	}  
	public void doBefore()  
	{  
		System.out.println("ǰ�ô���");  
	}  
	public void doAfter()  
	{  
		System.out.println("���ô���");  
	}  
}  

