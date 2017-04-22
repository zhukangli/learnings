package com.conley.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap map = new TreeMap();
		map.put("B", "B");
		map.put("A", "A");
		map.put("D", "D");
		map.put("a", "a");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry  = (Map.Entry)it.next();
			System.out.println(entry.getValue());
		}
		
		
				
	}
}
