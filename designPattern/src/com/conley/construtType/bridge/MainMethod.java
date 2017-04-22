package com.conley.construtType.bridge;
/**
 * ��ʵ��������ά���ϵ��Ž�
 * @author zhukangli
 *
 */
public class MainMethod {
	public static void main(String[] args) {
		//���������ʵ�ֶ���
		MessageImplementor impl = new MessageSMS();
		//������ͨ��Ϣ����
		AbstractMessage message = new  CommonMessage(impl);
		message.sendMessage("�Ӱ���������","����");

		//��ʵ�ַ�ʽ�л����ʼ����ٴη���
		impl = new MessageEmail();
		//�����Ӽ���Ϣ����
		message = new UrgencyMessage(impl);
		message.sendMessage("�Ӱ���������","����");
	}
}
