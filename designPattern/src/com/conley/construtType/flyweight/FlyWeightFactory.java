package com.conley.construtType.flyweight;

import java.util.Hashtable;

//ÏíÔª¹¤³§
public class FlyWeightFactory {
	public FlyWeightFactory() {}

	private Hashtable<String, ConcreteFlyWeight> flyWeights = new Hashtable<String, ConcreteFlyWeight>();

	public ConcreteFlyWeight factory(String str) {
		ConcreteFlyWeight flyWeight;
		flyWeight = flyWeights.get(str);
		if (null == flyWeight) {
			flyWeight = new ConcreteFlyWeight(str);
			flyWeights.put(str, flyWeight);
		}
		return flyWeight;
	}

	public int getFlyWeightSize() {
		return flyWeights.size();
	}
}
