package com.conley.Lambda;

/**
 * Created by Conley on 2017/4/16.
 */
public class PersonMain {
    public static void main(String[] args){
        PersonFactory<Person> factory = Person::new;
        Person p = factory.create("zhu","kangli");
        System.out.println(p);
    }


}
