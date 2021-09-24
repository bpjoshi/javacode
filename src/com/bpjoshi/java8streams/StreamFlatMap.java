package com.bpjoshi.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bhagwati Prasad
 * Flatmapping stream is dealing with one to many relation
 * new york = paris london
 * different people living in these cities .you need to count total number of people in all of the cities
 * you will make a cities stream and then for a city you will get people stream and then finally count.
 * flatMap returns a stream
 *
 * the flat map operation is defined by a function that takes an object and returns a stream of other objects
 *
 */
public class StreamFlatMap {
    public static void main(String[] args) {
        Person p1= new Person("Ab", 25);
        Person p2= new Person("Ac", 23);
        Person p3= new Person("Ad", 27);
        Person p4= new Person("Ae", 21);
        Person p5= new Person("Af", 29);
        Person p6= new Person("Ag", 19);
        Person p7= new Person("Ah", 18);
        Person p8= new Person("Ai", 18);

        City haldwani= new City("Haldwani", p1,p2,p3);
        City dehradun= new City("Dehradun", p4, p5, p6);
        City noida= new City("Noida", p7, p8);

        List<City> cities= Arrays.asList(haldwani, dehradun, noida);
        //I have to count total number of people living in each of these cities

        long count = cities.stream()
                .flatMap(city -> city.getPeople().stream()).count();

        System.out.print("total number of people living in all cities: "+count);

        cities.stream()
                .flatMap(city -> city.getPeople().stream()).forEach(p->{
                    System.out.print(p.getName()+" ");
                });
    }
}
