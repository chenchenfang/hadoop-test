package com.fang7.java.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListArrayToArray {
    public static void main(String[] args) {

        //数组转换成arraylist
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("123", "321", "333"));
        //arraylist转换成数组
        String[] strings1 = strings.toArray(new String[0]);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(10));
        people.add(new Person(100));
        people.add(new Person(20));
        people.add(new Person(50));
        Collections.sort(people);
        people.forEach(x -> System.out.println(x));

    }
}
@Data
class Person implements Comparable<Person>{
    Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age<o.age){
            return -1;
        }else if(this.age>o.age){
            return 1;
        }else{
            return 0;
        }
    }
}

