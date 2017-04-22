package com.conley.Lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 测试java.util.function包里面的几个类
 * Created by Conley on 2017/4/16.
 */
public class LambdaTest {
    public static void main(String[] args){
        testPredicate();
        testFunctions();
        testSuppiers();
        testConsumers();
        testOptional();
    }

    /***
     * 判断输入的对象是否符合某个条件
     */
    public static void testPredicate(){
        Predicate<String> predicate = (s) -> s.length()>0;
        predicate.test("aaa");
        //注意一下这个写法
        predicate.negate().test("foo");
        //定义了nonNull 指向的函数的定义是对象不为空
        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println(nonNull.test(null));
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
    }

    /**
     *  自定义函数，接受一个参数，返回单一结果
     */
    public static void testFunctions(){
        //Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一起（compse, andThen）：
        Function<String,Integer> strToInteger = Integer::valueOf;
        Function<String, String> backToString = strToInteger.andThen(String::valueOf);
        String i = backToString.apply("123");
        System.out.println(i);
    }

    /**
     * 不接受参数，直接返回一个给定类型的接口
     */
    public static void testSuppiers(){
        Supplier<Person> supplier = Person::new;
        Person p = supplier.get();
    }

    /**
     * 接受一个参数，对这个参数进行操作，但是不返回结果
     *
     */
    public static void testConsumers(){
        Supplier<Person> supplier = Person::new;
        Consumer<Person> consumer = (p) -> p.setFirstName("zhu");
        Person p = supplier.get();
        consumer.accept(p);
        System.out.println(p.getFirstName());
    }

    /**
     * 比较器
     */
    public static void testComparator(){
        Comparator<Person> comparator = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("zhu","kangli");
        Person p2 = new Person("zhou","jinyan");
        System.out.println(comparator.compare(p1,p2));
        System.out.println(comparator.reversed().compare(p1,p2));
    }

    public static void testOptional(){
        //不接受为null的参数，会抛异常
        Optional<String> optional = Optional.of("bam");
        //判断是否存在，即不为null
        System.out.println(optional.isPresent());
        //获取值，这里会抛异常
        //System.out.println(optional.get());
        //如果为null，就取其他值
        System.out.println(optional.orElse("bam"));
        //接受一个consumer参数，如果不为空，则做一些操作
        optional.ifPresent((s) -> System.out.println(s.toLowerCase()));

        // 接受为null的参数，返回一个empty的Optional
        Optional<String> optional1 = Optional.ofNullable(null);
        Optional<Person> optional2 = Optional.ofNullable(null);
        //这里会抛异常，因为没有value可以get
        //System.out.println(optional1.get());
        //System.out.println(optional2.get().getFirstName());

        //标准做法
        Person p1 = null;
        Person p =Optional.ofNullable(p1).orElse(new Person("zhu","kangli"));
        System.out.println(p.getFirstName());
    }
}
