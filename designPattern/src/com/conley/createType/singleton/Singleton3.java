package com.conley.createType.singleton;

/**
 * “双重检查”Double-Check
 * @author zhukangli
 *
 */
public class Singleton3 {
	//singleton = new Singleton()这句，步骤
	//1、给 singleton 分配内存
	//2、调用 Singleton 的构造函数来初始化成员变量，形成实例
	//3、将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
	//但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
	//如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），
	//所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
	
	//这里的votile就是解决上面问题
	private volatile  static Singleton3 singleton = null;
	private Singleton3()  {    }
	public static Singleton3 getInstance() {
		//第一个条件是说，如果实例创建了，那就不需要同步了，直接返回就好了。
		if (singleton== null)  {
			synchronized (Singleton3.class) {
				//不然，我们就开始同步线程。
				if (singleton== null)  {
					//第二个条件是说，如果被同步的线程中，有一个线程创建了对象，那么别的线程就不用再创建了。
					singleton= new Singleton3();
				}
			}
		}
		return singleton;
	}
}
