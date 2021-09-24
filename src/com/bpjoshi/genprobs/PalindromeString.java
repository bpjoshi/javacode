package com.bpjoshi.genprobs;

/**
 * @author Bhagwati Prasad
 * Check if a String is Palindrome or not
 */
public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome2("sas"));
    }

    private static boolean checkPalindrome(String str) {
        return str.equalsIgnoreCase(reverseString(str));
    }

    /**
     * recursive method to reverse a string
     * @param str input string
     * @return reverse of the input string str
     */
    private static String reverseString(String str) {
        if(str==null||str.isEmpty()){
            return str;
        }

        else return str.charAt(str.length()-1)+reverseString(str.substring(0,str.length()-1));
    }

    /**
     * Using StringBuilder
     * @param str input string
     * @return true if input string is a palindrome
     */
    private static boolean checkPalindrome2(String str) {
        StringBuilder sb= new StringBuilder(str);
        StringBuilder reverse = sb.reverse();
        return reverse.toString().equalsIgnoreCase(str);
    }
}
