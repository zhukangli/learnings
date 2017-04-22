package com.conley.behaviorType.state;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
    //����״�崦�����
    private VoteState state = null;
    //��¼�û�ͶƱ�Ľ����Map<String,String>��ӦMap<�û����ƣ�ͶƱ��ѡ��>
    private Map<String,String> mapVote = new HashMap<String,String>();
    //��¼�û�ͶƱ������Map<String,Integer>��ӦMap<�û����ƣ�ͶƱ�Ĵ���>
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();
    /**
     * ��ȡ�û�ͶƱ�����Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    /**
     * ͶƱ
     * @param user    ͶƱ��
     * @param voteItem    ͶƱ��ѡ��
     */
    public void vote(String user,String voteItem){
        //1.Ϊ���û�����ͶƱ����
        //�Ӽ�¼��ȡ�����û����е�ͶƱ����
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //2.�жϸ��û���ͶƱ���ͣ����൱���ж϶�Ӧ��״̬
        //����������ͶƱ���ظ�ͶƱ������ͶƱ�����Ϻ�������״̬
        if(oldVoteCount == 1){
            state = new NormalVoteState();
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = new RepeatVoteState();
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){
            state = new SpiteVoteState();
        }
        else if(oldVoteCount > 8){
            state = new BlackVoteState();
        }
        //Ȼ��ת��״̬������������Ӧ�Ĳ���
        state.vote(user, voteItem, this);
    }
}
