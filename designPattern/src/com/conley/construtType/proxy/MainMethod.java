package com.conley.construtType.proxy;

public class MainMethod {
	//������  
	public static void main(String[] args)  
	{  
		//���ñ�������Ϊ�����ɫ����  
		Business bi = new BusinessImplProxy();  
		bi.doAction();  
	}  
}
