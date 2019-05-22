package com.se.algorithm.SlidingWindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    // Given an array, find the average of all subarrays of size ‘K’ in it.
    // O (n * k)
    public static double[] findAverages(int[] arr, int k) {
        double[] averages = new double[arr.length - k + 1];

        for(int i = 0; i <= arr.length - k; i++) {
            double total = 0;
            for(int j = i; j < k + i; j++) {
                total += arr[j];
            }
            averages[i] = total / k;
        }
        return averages;
    }

    public static double[] findAveragesSlidingWindow(int[] arr, int k) {
        double[] averages = new double[arr.length - k + 1];
        int windowStart =  0;
        double windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd ++) {
            windowSum += arr[windowEnd];

            if(windowEnd >= k - 1) {
                averages[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return averages;
    }


    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAveragesSlidingWindow(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
