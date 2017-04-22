package com.conley.behaviorType.chainOfResponsibility;

public class Client {
	public static void main(String[] args) {

		//创建节点
		GroupLeader gl = new GroupLeader();
		ProjectManager pm = new ProjectManager();
		DepartmentManager dm = new DepartmentManager();
		CEO ceo = new CEO();
		//建立责任链
		gl.setHandler(pm);
		pm.setHandler(dm);
		dm.setHandler(ceo);

		//向小组长发出申请，请求审批4天的假期
		gl.approve(6D);


	}

}
