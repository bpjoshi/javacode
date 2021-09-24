package com.bpjoshi.genprobs;

/**
 * @author Bhagwati Prasad
 * Check if a number is an Armstrong number using recursion
 */
public class ArmstrongNumber {
    private static int digitsCubeSum=0;
    public static void main(String[] args) {
        // A number is an Armstrong number if the sum of cube of its digits equals the number itself
        System.out.println(153==sumOfDigitsCube(153));
    }

    /*
        recursively calculating sum of cubes of each digit in the number
     */
    private static int sumOfDigitsCube(int i) {
        if(i==0) {
            return digitsCubeSum;
        } else{
            digitsCubeSum += Math.pow(i % 10, 3);
            return sumOfDigitsCube(i/10);
        }
    }
}
