package com.conley.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Conley on 2017/4/22.
 */
public class StreamTest {
    private final static List<String> stringCollection = new ArrayList<>();
    //不加static的话在类构造器前面执行，不初始化的话就不会赋值
    static{
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    public static void main(String[] args) {
        testFilter();
        testSorted();
        testMap();
        testMatch();
        testCount();
        testReduce();
    }

    public static void testFilter(){
        System.out.println(stringCollection.size());
        //filter 方法接受一个Predicte参数，判断输入的对象是否符合某个条件
        //foreach 方法接受一个consumer参数，无返回值，用来对参数进行操作
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }


    public static void  testSorted(){
        //Sorted是一个中间操作，能够返回一个排过序的流对象的视图。
        // 流对象中的元素会默认按照自然顺序进行排序，除非你自己指定一个Comparator接口来改变排序规则。
        stringCollection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        //sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序。
        System.out.println(stringCollection);
    }

    public static void testMap(){
        //map 通过给定的方法，它能够把流对象中的每一个元素对应到另外一个对象上。
        stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        //可以看到，原来集合中的数据是不变的
        System.out.println(stringCollection);

    }
    //match 匹配操作有多种不同的类型，都是用来判断某一种规则是否与流对象相互吻合的。所有的匹配操作都是终结操作，只返回一个boolean类型的结果。
    public static void testMatch(){
        //anyMath 接受一个predicate参数，用来判断某个条件是否合法
        System.out.println(stringCollection.stream().anyMatch((s) -> s.startsWith("a")));
        System.out.println(stringCollection.stream().allMatch((s) -> s.startsWith("a")));
        System.out.println(stringCollection.stream().noneMatch((s) -> s.startsWith("a")));
    }

    //Count是一个终结操作，它的作用是返回一个数值，用来标识当前流对象中包含的元素数量。
    public static void testCount(){
        System.out.println(stringCollection.stream().filter((s) -> s.startsWith("a")).count());

    }

    //Reduce 操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。该操作的结果会放在一个Optional变量里返回。
    public static void testReduce(){
        Optional<String> optional = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        optional.ifPresent(System.out::println);
    }




}
