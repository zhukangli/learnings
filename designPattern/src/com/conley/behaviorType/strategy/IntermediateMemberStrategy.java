package com.conley.behaviorType.strategy;
/**
 * �����м���Ա�ۿ���
 * @author zhukangli
 *
 */
public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {

		System.out.println("�����м���Ա���ۿ�Ϊ10%");
		return booksPrice * 0.9;
	}

}
