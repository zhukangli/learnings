package com.conley.construtType.bridge;

public class MessageEmail implements MessageImplementor {

    @Override
    public void send(String message, String toUser) {
        System.out.println("ʹ���ʼ�����Ϣ�ķ�����������Ϣ'"+message+"'��"+toUser);
    }

}
