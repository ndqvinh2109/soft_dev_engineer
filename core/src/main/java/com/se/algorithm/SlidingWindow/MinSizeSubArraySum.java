package com.se.algorithm.SlidingWindow;

public class MinSizeSubArraySum {

    //Smallest Subarray with a given sum
    // Time O(N) Space O(1)
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= S) {

                if(minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }

}
