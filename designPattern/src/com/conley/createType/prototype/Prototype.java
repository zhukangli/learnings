package com.conley.createType.prototype;
/**
 * 实现Cloneable接口。
 * 在java语言有一个Cloneable接口，它的作用只有一个，
 * 就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。
 * 在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
 * @author zhukangli
 *
 */
public class Prototype implements Cloneable {
    //這裡重寫的原因是因為
	//不重寫的話，其他子類可能用不了，clone只能夠在自己的函數中使用，不能別人調用
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
