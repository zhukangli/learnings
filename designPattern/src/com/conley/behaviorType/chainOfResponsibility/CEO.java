package com.conley.behaviorType.chainOfResponsibility;

public class CEO extends Handler {

	@Override
	public boolean approve(double day) {
		System.out.println("���ž�������ͨ��");
		return true;

	}

}
