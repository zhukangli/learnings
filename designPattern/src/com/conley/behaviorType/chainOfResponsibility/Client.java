package com.conley.behaviorType.chainOfResponsibility;

public class Client {
	public static void main(String[] args) {

		//�����ڵ�
		GroupLeader gl = new GroupLeader();
		ProjectManager pm = new ProjectManager();
		DepartmentManager dm = new DepartmentManager();
		CEO ceo = new CEO();
		//����������
		gl.setHandler(pm);
		pm.setHandler(dm);
		dm.setHandler(ceo);

		//��С�鳤�������룬��������4��ļ���
		gl.approve(6D);


	}

}
