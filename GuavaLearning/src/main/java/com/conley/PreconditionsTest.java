package com.conley;


import com.google.common.base.Preconditions;

/**
 * Created by zhukangli on 2017/3/22.
 */
public class PreconditionsTest {
    public static void main(String[] args){
        Preconditions.checkArgument(1 < 0,"hi");
    }
}
