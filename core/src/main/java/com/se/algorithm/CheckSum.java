package com.se.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheckSum {

    /*
    An array with two integers a and b that add up to a certain number
    Sample Input
        arr = {1,21,3,14,5,60,7,6}
        value = 27
    Sample Output
        arr = {21,6} or {6,21}
    */
    public static int[] findSum(int[] arr, int value) {
        int[] result = new int[2];
        // write your code here

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(value - arr[i], i);
        }

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                result[k++] = arr[i];
            }
        }


        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }
}
