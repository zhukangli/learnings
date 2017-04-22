package com.conley;

/**
 * Created by Conley on 2017/4/16.
 */
interface Formula {
    //默认都是public的
    double calculate(int a);
    //支持扩展方法
   default double sqrt(int a){
         return Math.sqrt(a);
    }

}
