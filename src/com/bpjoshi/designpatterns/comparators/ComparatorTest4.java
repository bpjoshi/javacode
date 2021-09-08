package com.bpjoshi.designpatterns.comparators;

/**
 * @author Bhagwati Prasad
 * chaining
 */
public class ComparatorTest4 {
    public static void main(String[] args) {
        Person shrihari= new Person("Shrihari", 32);
        Person shrihari1= new Person("Shrihari", 33);
        Person sanat= new Person("Sanat", 35);
        //Function<Person, String> comparing= p->p.getName();
        //Comparator<Person> cmpName= Comparator.comparing(comparing);
        //above commented line written as
        Comparator<Person> cmpName= Comparator.comparing(p->p.getName());
        Comparator<Person> cmpAge=Comparator.comparing(p->p.getAge());
        Comparator<Person> cmp= cmpName.thenComparing(cmpAge);
        //should print false
        System.out.println("Shrihar>Sanat -> "+(cmp.compare(shrihari,shrihari1)>0));
    }
}
