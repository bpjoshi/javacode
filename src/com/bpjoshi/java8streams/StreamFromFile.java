package com.bpjoshi.java8streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Bhagwati Prasad
 * Stream from a file
 */
public class StreamFromFile {
    public static void main(String[] args) {
        Path path = Paths.get("data/first-names.txt");
        try(Stream<String> lines = Files.lines(path)){
            long count = lines.count();
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
