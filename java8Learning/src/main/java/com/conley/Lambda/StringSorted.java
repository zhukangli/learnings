package com.conley.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Conley on 2017/4/16.
 */
public class StringSorted {
    public static void main(String[] args){


    }

    public static void old(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

    public static void lambda(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(a,b) -> b.compareTo(a));
    }
}
