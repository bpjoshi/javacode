package com.bpjoshi.java8streams;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author Bhagwati Prasad
 * Stream from a regex
 */
public class StreamFromRegex {
    public static void main(String[] args) {
        String sentence="The quick brown fox jumps over the lazy dog";
        //NOT A GOOD way below ..we are storing array
        //stream api is there so that you dont store and just calculate
        //stream object dont have any data
        String[] words=sentence.split(" ");
        long count1 = Arrays.stream(words).count();
        System.out.println(count1);

        //Better way to do it...Pattern has splitAsStream method
        Pattern pattern=Pattern.compile(" ");
        long count = pattern.splitAsStream(sentence).count();
        System.out.println(count);
    }
}
