package com.se.algorithm;

public class MergeSortedArray {

    /*
        Merged array consisting all elements of both arrays in a sorted way

        Sample Input
            arr1 = {1,3,4,5}
            arr2 = {2,6,7,8}
        Sample Output
            arr = {1,2,3,4,5,6,7,8}
    */
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        int[] result = new int[size];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        // write your code here
        return result; // make a new resultant array and return your results in that
    }

    public static void main(String args[]) {

        int[] arr1 = {1,12,14,17,23}; // creating array 1
        int[] arr2 = {11,19,27};  // creating array 2

        int[] arr3 = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for(int i=0; i < arr1.length + arr2.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
