package com.conley.behaviorType.chainOfResponsibility;

public class GroupLeader extends Handler {

	@Override
	public boolean approve(double day) {
		if(day<0.5){
			System.out.println("С�鳤����ͨ��");
			return true;
		}else {
			System.out.println("С�鳤������������˾");
			return getHandler().approve(day);
		}
	}


}
