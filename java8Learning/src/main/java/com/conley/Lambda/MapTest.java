package com.conley.Lambda;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Conley on 2017/4/22.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1,"这里有值了");
        for (int i = 0; i < 10; i++) {
            // 为null才put值进去
            map.putIfAbsent(i, "val" + i);
        }
        // 遍历，接受一个BiConsume类参数，对值进行操作
        map.forEach((id, val) -> System.out.println(val));
        //不为空的时候就进行计算，接受一个BiFunction参数,传入T,R，返回V
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));             // val33


        //看源码可知道，如果新值返回null，这里会remove key
        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.get(9));
        map.containsKey(9);     // false
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true
        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33

        //移除的时候，value一定要对
        map.remove(3, "val3");
        map.get(3);             // val33
        map.remove(3, "val33");
        map.get(3);             // null

        //为null，则返回defalut的值，十分有用
        map.getOrDefault(42, "not found");  // not found

        //先看map中是否没有特定的key/value存在，如果是，则把key/value存入map，否则merging函数就会被调用，对现有的数值进行修改。
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat


    }

}
