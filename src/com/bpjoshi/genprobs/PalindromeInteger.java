package com.bpjoshi.genprobs;

/**
 * @author Bhagwati Prasad
 * Check if an Integer is a palindrome or not
 */
public class PalindromeInteger {
    private static int reversedNumer=0;

    public static void main(String[] args) {
        System.out.println(checkPalindrome(101));
    }

    private static boolean checkPalindrome(int i) {
            return i==reverseNum(i);
    }

    /*
        recursively reversing a number
     */
    private static int reverseNum(int i) {
        if(i==0)
            return reversedNumer;
        else {
            //number reversed till now
            reversedNumer=reversedNumer*10+i%10;
            //reverse the remaining number
            return reverseNum(i/10);
        }
    }
}
