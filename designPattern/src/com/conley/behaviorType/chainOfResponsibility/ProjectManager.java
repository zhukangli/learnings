package com.conley.behaviorType.chainOfResponsibility;

public class ProjectManager extends Handler{

	@Override
	public boolean approve(double day) {
		if(day<2){
			System.out.println("��Ŀ��������ͨ��");
			return true;
		}else {
			System.out.println("��Ŀ��������������˾");
			return getHandler().approve(day);
		}
	}

}
