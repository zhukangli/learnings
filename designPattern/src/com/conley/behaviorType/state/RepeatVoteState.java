package com.conley.behaviorType.state;

public class RepeatVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //�ظ�ͶƱ����ʱ��������
        System.out.println("�벻Ҫ�ظ�ͶƱ");
    }

}
