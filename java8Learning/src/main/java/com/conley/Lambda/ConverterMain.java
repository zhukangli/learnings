package com.conley.Lambda;

/**
 * Created by Conley on 2017/4/16.
 */
public class ConverterMain {
    public static void main(String[] args){
        //很容易理解，converter就是一个函数，只要定义好它的函数具体实现就可以初始化对象了
        Converter<String,Integer> converter = (f) -> Integer.valueOf(f);
        int to = converter.convert("123");
        System.out.println(to);

        //另外一种写法,Java 8 允许你通过::关键字获取方法或者构造函数的的引用
        //意思是covert函数就执行Integer.valueOf(String s);这个方法
        Converter<String,Integer> converter2 = Integer::valueOf;
        int to2 = converter2.convert("123");
        System.out.println(to2);
    }
}
