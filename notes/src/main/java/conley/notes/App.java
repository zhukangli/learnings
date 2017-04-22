package conley.notes;

import java.util.Enumeration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
/*    	String b =Integer.MAX_VALUE+"1";
    	System.out.println("b="+b);
    	A a = new A();
    	a.setA(Integer.MAX_VALUE+1);
    	System.out.println("a="+a.getA());
    	System.out.println("a的String值为"+a.getA().toString());
    	//==比较内存地址 ，String的equals方法重写了，地址不同比较值
    	System.out.println(b.equals(a.getA().toString()));
    	System.out.println(b==String.valueOf(a.getA()));
    	
        System.out.println( "Hello World!" );*/
    	Enumeration e = new Enumeration();
    	
    	
    }
    
    
    static class A{
    	private Integer a;

		public Integer getA() {
			return a;
		}

		public void setA(Integer a) {
			this.a = a;
		}
    	
    }
    
}
