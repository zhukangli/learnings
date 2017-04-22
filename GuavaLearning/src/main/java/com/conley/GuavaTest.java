package com.conley;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhukangli on 2017/3/22.
 */
public class GuavaTest {
    public static void main(String[] args){

        String key = null;
  /*      Optional<String> option = Optional.of(key);
        System.out.println(option.get());
        System.out.println(option.isPresent());*/

        Optional.fromNullable(key).or("test");
        System.out.println(Strings.isNullOrEmpty(key));

    }

}
