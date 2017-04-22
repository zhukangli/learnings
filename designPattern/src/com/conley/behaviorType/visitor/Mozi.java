package com.conley.behaviorType.visitor;

public class Mozi {
	static class Horse{
		
	} 
	static class WhiteHorse extends Horse{
    	
    }
	static class BlackHorse extends Horse{
    	
    }
    public void ride(Horse h){
        System.out.println("����");
    }
    
    public void ride(WhiteHorse wh){
        System.out.println("�����");
    }
    
    public void ride(BlackHorse bh){
        System.out.println("�����");
    }
    /**
     * ��Ȼ��Mozi���ride()�������������������ض��ɵġ������������ֱ������(Horse)������(WhiteHorse)������(BlackHorse)�����͵Ĳ�����
������ô������ʱ��������ӡ��ʲô����أ�����ǳ�����ӡ����ͬ�����С�����������֮��ī�ӷ���������Ķ�����
����Ϊʲô�أ����ζ�ride()�����ĵ��ô�����ǲ�ͬ�Ĳ�����Ҳ����wh��bh��������Ȼ���в�ͬ����ʵ���ͣ��������ǵľ�̬���Ͷ���һ���ģ�����Horse���͡�
�������ط����ķ����Ǹ��ݾ�̬���ͽ��еģ�������ɹ����ڱ���ʱ�ھ�����ˡ�
     * @param args
     */
    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
    }

}
