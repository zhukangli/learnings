package com.conley.createType.builder;
/**
 * 与抽象工厂的区别：
 * 在建造者模式里，有个指导者，由指导者来管理建造者，
 * 用户是与指导者联系的，指导者联系建造者最后得到产品。
 * 即建造模式可以强制实行一种分步骤进行的建造过程。
 * @author zhukangli
 *
 *如果没有这个指导者，就得自己去建造，很容易搞乱顺序
 *
 */
public class Director {
	private Builder builder; 

	public Director( Builder builder ) { 
		this.builder = builder; 
	} 
	public void construct() { 
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC(); 
	} 
}
