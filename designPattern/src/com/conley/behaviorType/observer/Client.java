package com.conley.behaviorType.observer;

public class Client {
    public static void main(String[] args) {
        //�����������
        ConcreteSubject subject = new ConcreteSubject();
        //�����۲��߶���
        Observer observer = new ConcreteObserver();
        //���۲��߶���Ǽǵ����������
        subject.attach(observer);
        //�ı���������״̬
        subject.change("new state");
    }
}
