package com.conley.test;

public class IntegerTest {
	public static void main(String[] args) {
		/*Integer a = 3;
		int b = 3;
		System.out.println(a == b);//
		Integer c = 128;
		int d =128;
		System.out.println(c == d);
		Integer f = 128;
		Integer g = new Integer(128);
		Integer h = new Integer(3);
		Integer i = 3;
		System.out.println(c == f);//堆上两个对象，false
		System.out.println(g == f);//堆上两个对象，false
		System.out.println(a == h);//a为常量池，h为堆，false
		System.out.println(a == i);//指向常量池，true
*/	
		Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        Integer i = 642;
        Long j = 642L;
        
        //System.out.println(i == j);
        System.out.println(i.equals(j));
        System.out.println(i==e+f);
        System.out.println(e.equals(f));
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
	
	}
}
