package com.conley.createType.singleton;
/***
 * 居然用枚举！！看上去好牛逼，通过EasySingleton.INSTANCE来访问，这比调用getInstance()方法简单多了。
默认枚举实例的创建是线程安全的，所以不需要担心线程安全的问题。
但是在枚举中的其他任何方法的线程安全由程序员自己负责。还有防止上面的通过反射机制调用私用构造器。
 * @author zhukangli
 *
 */
public enum  Singleton6 {
	INSTANCE;
}
