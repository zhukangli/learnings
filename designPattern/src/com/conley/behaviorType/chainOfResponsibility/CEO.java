package com.conley.behaviorType.chainOfResponsibility;

public class CEO extends Handler {

	@Override
	public boolean approve(double day) {
		System.out.println("部门经理审批通过");
		return true;

	}

}
