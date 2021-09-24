package com.bpjoshi.java8streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bhagwati Prasad
 *
 */
public class StreamSkippingAndLimiting {
    public static void main(String[] args) {
        //will print 0 to 29
        IntStream.range(0,30).forEach(index->System.out.print(index+" "));
        System.out.println("\n");
        //Skip will skip first 10 elements
        IntStream.range(0,30)
                .skip(10)
                .forEach(index->System.out.print(index+" "));
        System.out.println("\n");
        //skip & Limit
        //skip first 5 numbers and then print only 5 numbers after that
        IntStream.range(0,30)
                .skip(5)
                .limit(5)
                .forEach(index->System.out.print(index+" "));
        System.out.println("\n");
        //from a file
        Path path = Paths.get("data/first-names.txt");
        try(Stream<String> lines = Files.lines(path)){
            lines.skip(4).limit(3).forEach(System.out::print);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
