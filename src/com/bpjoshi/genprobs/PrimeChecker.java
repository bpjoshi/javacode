package com.bpjoshi.genprobs;

/**
 * @author Bhagwati Prasad
 * When checking if n is a prime, we need to check only till squareroot of n
 * Because if a factor is greater than the square root of n,
 * the other factor that would multiply with it to equal n is necessarily less than the square root of n.
 */
public class PrimeChecker {
    public static void main(String[] args) {
        System.out.println(checkPrime(29));
        System.out.println(checkPrimeMathsLogic(29));
    }

    private static boolean checkPrime(int i) {
        if(i==2 || i==3)
            return true;
        if(i%2==0)
            return false;
        //no need to check even numbers now
        //check odd numbers till the sqrt of the number
        else{
            int sqrt = (int) Math.sqrt(i) + 1;
            for(int j=3; j<sqrt; j+=2){
                if(i%j==0)
                    return false;
            }
            return true;
        }
    }

    /**
     * A prime number can always be written as 6n(+/_)1
     * there for any such number prime*prime minus 1 is always divisible by 24
     * @param i input number
     * @return true if it's a prime and false if it's not
     */
    private static boolean checkPrimeMathsLogic(int i) {
        if(i<0)
            return false;
        if(i==0||i==1)
            return false;
        if(i==2 || i==3)
            return true;
        return (i * i - 1) % 24 == 0;
    }
}
