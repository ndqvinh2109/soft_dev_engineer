package com.se.algorithm;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            if (hm.containsKey(arr[i])) {
                result[k++] = arr[i];
            }
        }

        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }


    public String solution(String s) {
        char c = s.charAt(0);
        if (Character.isUpperCase(c)) {  // please fix condition
            return "upper";
        } else if (Character.isLowerCase(c)) {  // please fix condition
            return "lower";
        } else if (Character.isDigit(c)) {  // please fix condition
            return "digit";
        } else {
            return "other";
        }

    }


    public String solution2(int A) {
        String s = String.valueOf(A);

        StringBuilder returnedS = new StringBuilder();

        int i = -1;
        int j = s.length();

        while ((i + 1) != j) {

            ++i;
            j = s.length() - i - 1;

            returnedS.append(s.charAt(i));

            if (i < j) {
                returnedS.append(s.charAt(j));
            }


        }


        return returnedS.toString();

    }


    public static void main(String args[]) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        prettyPrint(numbers, 7);
        prettyPrint(numbersWithDuplicates, 7);
    }

    /**
     * Prints all pair of integer values from given array whose sum is is equal to given number. * complexity of this solution is O(n^2)
     */
    public static void printPairs(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if ((first + second) == sum) {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }
        }
    }

    /**
     * Utility method to print input and output for better explanation.
     */
    public static void prettyPrint(int[] givenArray, int givenSum) {
        System.out.println("Given array : " + Arrays.toString(givenArray));
        System.out.println("Given sum : " + givenSum);
        System.out.println("Integer numbers, whose sum is equal to value : " + givenSum);
        printPairs(givenArray, givenSum);
    }


}

