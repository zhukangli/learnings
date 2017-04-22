package com.conley.behaviorType.chainOfResponsibility;

public class GroupLeader extends Handler {

	@Override
	public boolean approve(double day) {
		if(day<0.5){
			System.out.println("小组长审批通过");
			return true;
		}else {
			System.out.println("小组长传给了他的上司");
			return getHandler().approve(day);
		}
	}


}
