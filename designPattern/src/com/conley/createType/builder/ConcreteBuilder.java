package com.conley.createType.builder;

//具体建造工具
public class ConcreteBuilder implements Builder { 
	Part partA, partB, partC; 

	public void buildPartA() {
		//这里是具体如何构建partA的代码
	}; 
	public void buildPartB() { 
		//这里是具体如何构建partB的代码
	}; 
	public void buildPartC() { 
		//这里是具体如何构建partB的代码
	}; 
	public Product getResult(){
		return null; 
		//返回最后组装成品结果
	}; 
}
