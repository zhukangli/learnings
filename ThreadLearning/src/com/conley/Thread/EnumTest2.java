package com.conley.Thread;

public enum EnumTest2{
	APPLE("ƻ��"),PEAR("����");
	//���ɵ����Ӷ���static final�ģ����Բ�����public
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
