package com.conley.createType.prototype;
/**
 * ʵ��Cloneable�ӿڡ�
 * ��java������һ��Cloneable�ӿڣ���������ֻ��һ����
 * ����������ʱ֪ͨ��������԰�ȫ����ʵ���˴˽ӿڵ�����ʹ��clone������
 * ��java������У�ֻ��ʵ��������ӿڵ���ſ��Ա�����������������ʱ���׳�CloneNotSupportedException�쳣��
 * @author zhukangli
 *
 */
public class Prototype implements Cloneable {
    //�@�e�،���ԭ�������
	//���،���Ԓ������������ò��ˣ�cloneֻ�܉����Լ��ĺ�����ʹ�ã����܄e���{��
	public Prototype clone(){  
        Prototype prototype = null;  
        try{  
            prototype = (Prototype)super.clone();  
        }catch(CloneNotSupportedException e){  
            e.printStackTrace();  
        }  
        return prototype;   
    }  
}
