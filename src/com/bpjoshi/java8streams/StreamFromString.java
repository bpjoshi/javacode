package com.bpjoshi.java8streams;

/**
 * @author Bhagwati Prasad
 * Creating stream from a String
 */
public class StreamFromString {
    public static void main(String[] args) {
        String sentence="the quick brown fox jumps over the lazy dog";
        sentence.chars()
                .mapToObj(asciiCode->Character.toString((char)asciiCode))
                .distinct()
                .sorted()
                .forEach(letter->System.out.print(letter));
    }
}
