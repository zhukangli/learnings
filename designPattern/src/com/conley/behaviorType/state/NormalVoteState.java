package com.conley.behaviorType.state;

public class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //����ͶƱ����¼��ͶƱ��¼��
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("��ϲͶƱ�ɹ�");
    }

}
