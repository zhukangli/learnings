package com.conley.behaviorType.chainOfResponsibility;

public class DepartmentManager extends Handler{
	@Override
	public boolean approve(double day) {
		if(day<5){
			System.out.println("���ž�������ͨ��");
			return true;
		}else {
			System.out.println("���ž�������������˾");
			return getHandler().approve(day);
		}
	}
}
