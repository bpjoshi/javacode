package com.bpjoshi.designpatterns.comparators;

import java.util.function.Function;

/**
 * @author Bhagwati Prasad
 *
 */
public class ComparatorTest2 {
    public static void main(String[] args) {
        Person shrihari= new Person("Shrihari", 32);
        Person mitali= new Person("Mitali", 34);
        Person mayur= new Person("Mayur", 31);
        Person sanat= new Person("Sanat", 35);
        //Function<Person, String> comparing= p->p.getName();
        //Comparator<Person> cmpName= Comparator.comparing(comparing);
        //above commented line written as
        Comparator<Person> cmpName= Comparator.comparing(p->p.getName());
        System.out.println("Shrihar>Sanat -> "+(cmpName.compare(shrihari,sanat)>0));
    }
}
