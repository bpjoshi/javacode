package com.bpjoshi.programs;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1, 3, 5, 7, 9, 11, 13, 15};
        int i = giveIndex(arr, 8, 0, 7);
        System.out.println(i);
    }

    static int giveIndex(int[] arr, int n, int start, int end){
        int mid=(start+end)/2;
        if(start>end)
            return -1;
        if(n==arr[mid])
            return mid;
        if(n<arr[mid]){
           return giveIndex(arr, n, start, mid-1);
        }
        if(n>arr[mid]){
          return  giveIndex(arr, n, mid+1, end);
        }
        return -1;
    }
}
