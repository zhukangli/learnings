package com.conley.createType.builder;

//���彨�칤��
public class ConcreteBuilder implements Builder { 
	Part partA, partB, partC; 

	public void buildPartA() {
		//�����Ǿ�����ι���partA�Ĵ���
	}; 
	public void buildPartB() { 
		//�����Ǿ�����ι���partB�Ĵ���
	}; 
	public void buildPartC() { 
		//�����Ǿ�����ι���partB�Ĵ���
	}; 
	public Product getResult(){
		return null; 
		//���������װ��Ʒ���
	}; 
}
