package com.conley.Thread;

public enum EnumTest2{
	APPLE("苹果"),PEAR("梨子");
	//生成的例子都是static final的，所以不能用public
	EnumTest2(String name){
		this.name=name;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
