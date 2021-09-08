package com.bpjoshi.designpatterns.comparators;

/**
 * @author Bhagwati Prasad
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person shrihari= new Person("Shrihari", 32);
        Person mitali= new Person("Mitali", 34);
        Person mayur= new Person("Mayur", 31);
        Person sanat= new Person("Sanat", 35);

        Comparator<Person> cmpName=(p1, p2) ->p1.getName().compareTo(p2.getName());
        System.out.println("Shrihar>Sanat -> "+(cmpName.compare(shrihari,sanat)>0));
    }
}
