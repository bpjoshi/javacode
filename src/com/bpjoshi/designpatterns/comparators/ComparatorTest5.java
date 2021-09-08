package com.bpjoshi.designpatterns.comparators;

/**
 * @author Bhagwati Prasad
 */
public class ComparatorTest5 {
    public static void main(String[] args) {
        Person shrihari= new Person("Shrihari", 32);
        Person shrihari1= new Person("Shrihari", 33);
        Person sanat= new Person("Sanat", 35);

        Comparator<Person> cmpName= Comparator.comparing(p->p.getName());
        Comparator<Person> cmpAge=Comparator.comparing(p->p.getAge());
        Comparator<Person> cmp= Comparator.comparing(Person::getName).thenComparing(Person::getAge);
        //should print false
        System.out.println("Shrihar>Sanat -> "+(cmp.compare(shrihari,shrihari1)>0));
    }
}
