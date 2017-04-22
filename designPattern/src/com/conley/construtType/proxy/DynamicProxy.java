package com.conley.construtType.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//抽象角色：java动态代理的实现目前只支持接口，不支持抽象类
interface BusinessFoo
{
	void foo();
}
interface BusinessBar
{
	String bar(String message);
}
//真实角色：真正实现业务逻辑方法
class BusinessFooImpl implements BusinessFoo
{
	public void foo()
	{
		System.out.println("BusinessFooImpl.foo()");
	}
}
class BusinessBarImpl implements BusinessBar
{
	public String bar(String message)
	{
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}
}
/**
 * 这里一个类解决所有，不需要像静态代理一样，每个都写一个代理类
 * @author zhukangli
 *
 */
class BusinessImplProxy1 implements InvocationHandler
{
	private Object obj;
	BusinessImplProxy1() {
	}
	BusinessImplProxy1(Object obj) {
		this.obj = obj;
	}
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable
	{
		Object result = null;
		doBefore();
		result = method.invoke(obj,args);
		doAfter();
		return result;
	}
	public void doBefore(){
		System.out.println("do something before Business Logic");
	}
	public void doAfter(){
		System.out.println("do something after Business Logic");
	}
	public static Object factory(Object obj)
	{
		Class cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),new BusinessImplProxy1(obj));
	}
}
//测试类
public class DynamicProxy
{    
	public static void main(String[] args) throws Throwable
	{
		BusinessFooImpl bfoo = new BusinessFooImpl();
		BusinessFoo bf = (BusinessFoo)BusinessImplProxy1.factory(bfoo);
		bf.foo();
		System.out.println();

		BusinessBarImpl bbar = new BusinessBarImpl();
		BusinessBar bb = (BusinessBar)BusinessImplProxy1.factory(bbar);
		String message = bb.bar("Hello,World");
		System.out.println(message);
	}
}
