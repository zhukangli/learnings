package com.conley.Lambda;

/**
 * Created by Conley on 2017/4/16.
 */
//函数式接口注解，编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);

}
