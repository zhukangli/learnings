package com.conley.behaviorType.strategy;
/**
 * ��������Ա�ۿ���
 * @author zhukangli
 *
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("���ڳ�����Ա��û���ۿ�");
        return booksPrice;
    }

}
