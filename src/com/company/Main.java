package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    mapToUpperCase("asSd").stream().forEach(System.out::println);
        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("asdasd","asd","assaaaaa"));
        List<String> a=new ArrayList<>();
        a.add("element1");
        a.add("element2");
        List<List<String>> b=new ArrayList<>();
        b.add(a);
        transform(b).stream().forEach(System.out::println);
        Person p1=new Person("a",1);
        Person p2=new Person("b",20);
        List<Person> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        System.out.println(getOldestPerson(list).getAge());
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(20);
        System.out.println(calculate(list1));
        System.out.println("----");
        getKidsName(list).stream().forEach(System.out::println);
     }

    public static Collection<String> mapToUpperCase(String ... s){
        return Arrays.stream(s).map(String::toUpperCase).collect(Collectors.toList());
    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... s){
        return Arrays.stream(s).filter(t->t.length()>5).mapToInt(String::length).sum();
    }

    public static List<String> transform(List<List<String>> collection){
        return collection.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static Person getOldestPerson(List<Person> people){
        return people.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);
    }

    public static int calculate(List<Integer> numbers){
        return numbers.stream().reduce(Integer::sum).orElse(0);
    }

    public static Set<String> getKidsName(List<Person> people){
        return people.stream().filter(p->p.getAge()<18).map(Person::getName).collect(Collectors.toSet());
    }
}
