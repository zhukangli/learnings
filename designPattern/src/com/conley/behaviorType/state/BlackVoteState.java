package com.conley.behaviorType.state;

public class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //��¼�������У���ֹ��¼ϵͳ
        System.out.println("���������������ֹ��¼��ʹ�ñ�ϵͳ");
    }

}
