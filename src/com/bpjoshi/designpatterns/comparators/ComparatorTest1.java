package com.bpjoshi.designpatterns.comparators;

import java.util.function.Function;

/**
 * @author Bhagwati Prasad
 * Improving code with Function and extracting method
 */
public class ComparatorTest1 {
    public static void main(String[] args) {
        Person shrihari= new Person("Shrihari", 32);
        Person mitali= new Person("Mitali", 34);
        Person mayur= new Person("Mayur", 31);
        Person sanat= new Person("Sanat", 35);
        Function<Person, String> comparing=p->p.getName();
        Comparator<Person> cmpName= getPersonComparator(comparing);
        System.out.println("Shrihar>Sanat -> "+(cmpName.compare(shrihari,sanat)>0));
    }

    private static Comparator<Person> getPersonComparator(Function<Person, String> comparing) {
        return (p1, p2) ->{
            String s1 = comparing.apply(p1);
            String s2 = comparing.apply(p2);
            return s1.compareTo(s2);
        };
    }
}
