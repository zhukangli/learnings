package com.conley.Lambda;

/**
 * Created by Conley on 2017/4/16.
 */
public interface PersonFactory<T extends Person> {
    T create(String firstName,String lastName);
}
